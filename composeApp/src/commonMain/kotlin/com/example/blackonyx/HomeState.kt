package com.example.blackonyx

import com.example.blackonyx.domain.Note

data class HomeState(
  val notes: List<Note> = listOf()
)