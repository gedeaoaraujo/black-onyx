package com.example.blackonyx

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class HomeState(
  val notes: List<Note> = listOf()
)

class HomeViewModel: ViewModel() {

  var state = MutableStateFlow(HomeState())
    private set

  init {
    val items = mutableListOf<Note>()
    repeat(10){ items.add(Note()) }
    state.update { it.copy(notes = items) }
  }

}