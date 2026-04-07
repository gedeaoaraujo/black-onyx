package com.example.blackonyx.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ViewNoteViewModel(
  val repository: ViewNoteRepository = ViewNoteRepository(),
  val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {
  val state = MutableStateFlow(ViewNoteState())

  fun onAction(action: ViewNoteIntent) = when(action) {
    is ViewNoteIntent.LoadNote -> loadNote(action.id)
  }

  private fun loadNote(id: Int) = viewModelScope.launch(ioDispatcher) {
    val note = repository.loadNote(id)
    state.update { it.copy(note = note) }
  }
}