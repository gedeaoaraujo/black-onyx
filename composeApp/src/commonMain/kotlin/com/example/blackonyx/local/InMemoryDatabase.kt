package com.example.blackonyx.local

import com.example.blackonyx.domain.Note

object InMemoryDatabase: LocalDatabase {
  private val notes = mutableListOf<Note>()

  init {
    repeat(3){ id -> notes.add(
      Note(
        id = id,
        title = "This is a title $id",
        description = "a".repeat(1500)
      )
    )}
  }

  override suspend fun getAllNotes(): List<Note> {
    return notes.toList()
  }

  override suspend fun getNote(id: Int): Note {
    return notes.first { it.id == id }
  }

  override suspend fun createNote(note: Note) {
    notes.add(note.copy(id = notes.count()))
  }

}