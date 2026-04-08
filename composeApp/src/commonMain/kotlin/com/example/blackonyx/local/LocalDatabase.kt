package com.example.blackonyx.local

import com.example.blackonyx.domain.Note
import kotlinx.coroutines.flow.Flow

interface LocalDatabase {
  fun getAllNotes(): Flow<List<Note>>
  suspend fun getNote(id: Int): Note
  suspend fun createNote(note: Note)
}