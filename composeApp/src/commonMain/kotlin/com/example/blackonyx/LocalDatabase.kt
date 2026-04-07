package com.example.blackonyx

interface LocalDatabase {
  suspend fun getAllNotes(): List<Note>
}