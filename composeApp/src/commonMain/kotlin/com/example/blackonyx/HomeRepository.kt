package com.example.blackonyx

class HomeRepository(
  val database: LocalDatabase = InMemoryDatabase()
) {

  suspend fun getAllNotes(): List<Note> {
    return database.getAllNotes()
  }
}