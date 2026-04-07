package com.example.blackonyx.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
  val repository: HomeRepository = HomeRepository(),
  val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

  val state = MutableStateFlow(HomeState())

  fun onAction(action: HomeIntent) = when(action) {
    HomeIntent.LoadAllNotes -> getAllNotes()
    HomeIntent.CreateNewNote -> createNewNote()
  }

  private fun createNewNote() = viewModelScope.launch(ioDispatcher) {
    repository.createNewNote()
    getAllNotes()
  }

  private fun getAllNotes() = viewModelScope.launch(ioDispatcher) {
    val notes = repository.getAllNotes()
    state.update { it.copy(notes = notes) }
  }

}