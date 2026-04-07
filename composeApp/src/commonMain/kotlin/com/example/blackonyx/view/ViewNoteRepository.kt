package com.example.blackonyx.view

import com.example.blackonyx.domain.Note
import com.example.blackonyx.local.InMemoryDatabase
import com.example.blackonyx.local.LocalDatabase

class ViewNoteRepository(
  val database: LocalDatabase = InMemoryDatabase
) {

  suspend fun loadNote(id: Int): Note {
    return database.getNote(id)
  }

}