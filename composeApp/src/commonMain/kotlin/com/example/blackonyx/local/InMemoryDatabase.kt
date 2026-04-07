package com.example.blackonyx.local

import com.example.blackonyx.domain.Note

class InMemoryDatabase: LocalDatabase {
  private val notes = mutableListOf<Note>()

  init {
    repeat(10){ notes.add(Note()) }
  }

  override suspend fun getAllNotes(): List<Note> {
    return notes.toList()
  }

}