package com.example.blackonyx.domain

data class Note(
  val title: String = "This is a title",
  val date: String = "06/04/2026 14:00",
  val description: String = "a".repeat(255)
)