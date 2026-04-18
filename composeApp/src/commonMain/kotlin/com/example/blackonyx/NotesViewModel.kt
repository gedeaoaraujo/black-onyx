package com.example.blackonyx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackonyx.domain.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class NotesState(
  val text: String = "",
  val title: String = "",
  val showDialog: Boolean = false,
  val date: String = dateTimeNow()
)

sealed class NotesIntent {
  object CreateNote: NotesIntent()
  object ToggleDialog: NotesIntent()
  data class LoadNote(val id: Int): NotesIntent()
  data class UpdateText(val text: String): NotesIntent()
  data class UpdateTitle(val title: String): NotesIntent()
}

class NotesViewModel(
  val repository: NotesRepository = NotesRepository(),
  val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
): ViewModel() {

  val state = MutableStateFlow(NotesState())
  val notes: StateFlow<HomeState> = repository.getAllNotes()
    .map { notes ->
      HomeState(notes)
    }
    .stateIn(
      viewModelScope,
      SharingStarted.WhileSubscribed(5_000),
      HomeState()
    )

  fun onAction(action: NotesIntent) = when(action) {
    is NotesIntent.CreateNote -> createNote()
    is NotesIntent.LoadNote -> loadNote(action.id)
    is NotesIntent.ToggleDialog -> state.update {
      it.copy(showDialog = state.value.showDialog.not())
    }
    is NotesIntent.UpdateTitle -> state.update {
      it.copy(title = action.title)
    }
    is NotesIntent.UpdateText -> state.update {
      it.copy(text = action.text)
    }
  }

  private fun loadNote(id: Int) = viewModelScope.launch(ioDispatcher) {
    val note = repository.loadNote(id)
    state.update { it.copy(
      text = note.description,
      title = note.title,
      date = note.date,
    )}
  }

  private fun createNote() = viewModelScope.launch(ioDispatcher) {
    if (state.value.title.isBlank() ||
      state.value.text.isBlank()) return@launch

    repository.createNote(Note(
      title = state.value.title,
      date = state.value.date,
      description = state.value.text
    ))
    state.update { NotesState() }
  }


}