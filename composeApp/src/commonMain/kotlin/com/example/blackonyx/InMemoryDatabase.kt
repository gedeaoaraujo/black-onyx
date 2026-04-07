package com.example.blackonyx

class InMemoryDatabase: LocalDatabase {
  private val notes = mutableListOf<Note>()

  init {
    repeat(10){ notes.add(Note()) }
  }

  override suspend fun getAllNotes(): List<Note> {
    return notes.toList()
  }

}