package com.example.blackonyx.home

import com.example.blackonyx.local.InMemoryDatabase
import com.example.blackonyx.local.LocalDatabase
import com.example.blackonyx.domain.Note

class HomeRepository(
  val database: LocalDatabase = InMemoryDatabase()
) {

  suspend fun getAllNotes(): List<Note> {
    return database.getAllNotes()
  }

  suspend fun createNewNote() {
    database.createNewNote()
  }
}