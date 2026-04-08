package com.example.blackonyx.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
  val repository: HomeRepository = HomeRepository(),
  val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

  val state: StateFlow<HomeState> = repository.getAllNotes()
    .map { notes ->
      HomeState(notes)
    }
    .stateIn(
      viewModelScope,
      SharingStarted.WhileSubscribed(5_000),
      HomeState()
    )

}