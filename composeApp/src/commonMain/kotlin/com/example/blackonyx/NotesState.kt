package com.example.blackonyx

data class NotesState(
  val id: Int = 0,
  val text: String = "",
  val title: String = "",
  val password: String = "",
  val showDialog: Boolean = false,
  val showTopBar: Boolean = false,
  val date: String = dateTimeNow(),
  val isDarkTheme: Boolean = true,
  val navigateHome: Boolean = false,
  val clickableCheck: Boolean = false,
  val showPasswordError: Boolean = false,
)