package com.example.blackonyx.local

import com.example.blackonyx.domain.Note

class InMemoryDatabase: LocalDatabase {
  private val notes = mutableListOf<Note>()

  init {
    repeat(10){ id -> notes.add(Note(id = id)) }
  }

  override suspend fun getAllNotes(): List<Note> {
    return notes.toList()
  }

  override suspend fun createNewNote() {
    notes.add(Note(
      id = notes.count(),
      description = "x".repeat(255)
    ))
  }
  }

}