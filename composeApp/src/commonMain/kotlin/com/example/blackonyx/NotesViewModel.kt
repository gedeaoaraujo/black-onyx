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
  val id: Int = 0,
  val text: String = "",
  val title: String = "",
  val showDialog: Boolean = false,
  val date: String = dateTimeNow(),
  val clickableCheck: Boolean = false
)

sealed class NotesIntent {
  object SaveNote: NotesIntent()
  object DeleteNote: NotesIntent()
  object CreateNote: NotesIntent()
  object ToggleDialog: NotesIntent()
  data class ViewNote(val id: Int): NotesIntent()
  data class UpdateText(val text: String): NotesIntent()
  data class UpdateTitle(val title: String): NotesIntent()
}

class NotesViewModel(
  private val repository: NotesRepository = NotesRepository(),
  private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
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

  fun onAction(action: NotesIntent) {
    when(action) {
      is NotesIntent.SaveNote -> saveNote()
      is NotesIntent.ViewNote -> viewNote(action.id)
      is NotesIntent.ToggleDialog -> state.update {
        it.copy(showDialog = state.value.showDialog.not())
      }
      is NotesIntent.UpdateTitle -> {
        state.update { it.copy(title = action.title) }
        checkClickable()
      }
      is NotesIntent.UpdateText -> {
        state.update { it.copy(text = action.text) }
        checkClickable()
      }
      is NotesIntent.CreateNote -> createNewNote()
      is NotesIntent.DeleteNote -> deleteNote()
    }
  }

  private fun deleteNote() = viewModelScope.launch(ioDispatcher) {
    repository.deleteNote(state.value.id)
  }

  private fun createNewNote() {
    state.update { NotesState() }
  }

  private fun checkClickable(){
    val title = state.value.title
    val text = state.value.text
    state.update { it.copy(
      clickableCheck = title.isNotBlank() && text.isNotBlank()
    )}
  }

  private fun viewNote(id: Int) = viewModelScope.launch(ioDispatcher) {
    val note = repository.viewNote(id)
    state.update { it.copy(
      id = id,
      text = note.description,
      title = note.title,
      date = note.date,
    )}
  }

  private fun saveNote() = viewModelScope.launch(ioDispatcher) {
    repository.createNote(Note(
      title = state.value.title,
      date = state.value.date,
      description = state.value.text
    ))
  }


}