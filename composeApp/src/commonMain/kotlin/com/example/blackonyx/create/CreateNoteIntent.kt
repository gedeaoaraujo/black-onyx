package com.example.blackonyx.create

sealed class CreateNoteIntent {
  object CreateNote: CreateNoteIntent()
  object ToggleDialog: CreateNoteIntent()
  data class UpdateTitle(val title: String): CreateNoteIntent()
  data class UpdateText(val text: String): CreateNoteIntent()
}