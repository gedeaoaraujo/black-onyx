package com.example.blackonyx.local

import com.example.blackonyx.domain.Note

interface LocalDatabase {
  suspend fun getAllNotes(): List<Note>
}