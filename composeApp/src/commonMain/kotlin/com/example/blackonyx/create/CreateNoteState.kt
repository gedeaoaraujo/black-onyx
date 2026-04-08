package com.example.blackonyx.create

import com.example.blackonyx.dateTimeNow

data class CreateNoteState(
  val title: String = "",
  val text: String = "",
  val date: String = dateTimeNow()
)