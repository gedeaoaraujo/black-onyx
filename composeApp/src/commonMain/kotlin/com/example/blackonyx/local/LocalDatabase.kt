package com.example.blackonyx.local

import com.example.blackonyx.domain.Note

interface LocalDatabase {
  suspend fun getAllNotes(): List<Note>
  suspend fun getNote(id: Int): Note
  suspend fun createNote(note: Note)
}