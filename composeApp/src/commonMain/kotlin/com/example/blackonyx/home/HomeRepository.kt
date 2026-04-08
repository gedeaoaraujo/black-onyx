package com.example.blackonyx.home

import com.example.blackonyx.domain.Note
import com.example.blackonyx.local.InMemoryDatabase
import com.example.blackonyx.local.LocalDatabase
import kotlinx.coroutines.flow.Flow

class HomeRepository(
  val database: LocalDatabase = InMemoryDatabase
) {

  fun getAllNotes(): Flow<List<Note>> {
    return database.getAllNotes()
  }

}