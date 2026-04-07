package com.example.blackonyx.home

import com.example.blackonyx.domain.Note

data class HomeState(
  val notes: List<Note> = listOf()
)