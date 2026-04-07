package com.example.blackonyx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeState(
  val notes: List<Note> = listOf()
)

class HomeViewModel(
  val repository: HomeRepository = HomeRepository(),
  val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

  var state = MutableStateFlow(HomeState())
    private set

  init {
    getAllNotes()
  }

  fun getAllNotes() = viewModelScope.launch(ioDispatcher) {
    val notes = repository.getAllNotes()
    state.update { it.copy(notes = notes) }
  }

}