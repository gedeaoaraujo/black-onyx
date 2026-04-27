package com.example.blackonyx

import com.example.blackonyx.domain.Note
import com.example.blackonyx.local.InMemoryDatabase
import com.example.blackonyx.local.LocalDatabase
import kotlinx.coroutines.flow.Flow

class NotesRepository(
  val database: LocalDatabase = InMemoryDatabase
) {

  fun getAllNotes(): Flow<List<Note>> {
    return database.getAllNotes()
  }

  suspend fun viewNote(id: Int): Note {
    return database.getNote(id)
  }

  suspend fun createNote(note: Note) {
    database.createNote(note)
  }

  suspend fun deleteNote(id: Int) {
    database.deleteNoteById(id)
  }

  suspend fun checkPassword(password: String): Boolean {
    return database.checkPassword(password)
  }

}