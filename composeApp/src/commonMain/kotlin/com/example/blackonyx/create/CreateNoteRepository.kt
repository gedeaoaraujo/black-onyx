package com.example.blackonyx.create

import com.example.blackonyx.domain.Note
import com.example.blackonyx.local.InMemoryDatabase
import com.example.blackonyx.local.LocalDatabase

class CreateNoteRepository(
  val database: LocalDatabase = InMemoryDatabase
) {

  suspend fun createNote(note: Note) {
    database.createNote(note)
  }

}