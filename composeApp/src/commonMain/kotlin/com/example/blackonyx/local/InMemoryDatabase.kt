package com.example.blackonyx.local

import com.example.blackonyx.domain.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.MutableStateFlow

object InMemoryDatabase: LocalDatabase {
  private val _notes = MutableStateFlow<List<Note>>(emptyList())

  init {
    val initial = List(3){ id ->
      Note(
        id = id,
        title = "This is a title $id",
        description = "a".repeat(1500)
      )
    }
    _notes.update { it + initial }
  }

  override fun getAllNotes(): Flow<List<Note>> = _notes

  override suspend fun getNote(id: Int): Note {
    return _notes.value.first { it.id == id }
  }

  override suspend fun createNote(note: Note) {
    val count = _notes.value.count()
    _notes.update { it + note.copy(id = count) }
  }

}