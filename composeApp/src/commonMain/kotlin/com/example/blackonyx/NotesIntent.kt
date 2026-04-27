package com.example.blackonyx

sealed class NotesIntent {
  object SaveNote: NotesIntent()
  object DeleteNote: NotesIntent()
  object CreateNote: NotesIntent()
  object ToggleTheme: NotesIntent()
  object ToggleDialog: NotesIntent()
  object CheckPassword: NotesIntent()
  data class ViewNote(val id: Int): NotesIntent()
  data class UpdateText(val text: String): NotesIntent()
  data class UpdateTitle(val title: String): NotesIntent()
  data class UpdatePassword(val password: String): NotesIntent()
}