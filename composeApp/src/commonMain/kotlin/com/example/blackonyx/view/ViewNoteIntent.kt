package com.example.blackonyx.view

sealed class ViewNoteIntent {
  data class LoadNote(val id: Int): ViewNoteIntent()
}