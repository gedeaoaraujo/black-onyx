package com.example.blackonyx.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blackonyx.domain.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateNoteViewModel(
  val repository: CreateNoteRepository = CreateNoteRepository(),
  val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

  val state = MutableStateFlow(CreateNoteState())

  fun onAction(action: CreateNoteIntent) = when(action) {
    is CreateNoteIntent.CreateNote -> createNote()
    is CreateNoteIntent.ToggleDialog -> state.update {
      it.copy(showDialog = state.value.showDialog.not())
    }
    is CreateNoteIntent.UpdateTitle -> state.update {
      it.copy(title = action.title)
    }
    is CreateNoteIntent.UpdateText -> state.update {
      it.copy(text = action.text)
    }
  }

  private fun createNote() = viewModelScope.launch(ioDispatcher) {
    if (state.value.title.isNotBlank()
      && state.value.text.isNotBlank()){
      repository.createNote(Note(
        title = state.value.title,
        date = state.value.date,
        description = state.value.text
      ))
    }
  }

}