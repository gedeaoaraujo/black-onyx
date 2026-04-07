package com.example.blackonyx.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ViewNote(
  noteId: Int = 0,
  modifier: Modifier = Modifier,
  viewModel: ViewNoteViewModel = ViewNoteViewModel()
){
  val state by viewModel.state.collectAsStateWithLifecycle()

  LaunchedEffect(Unit){
    viewModel.onAction(ViewNoteIntent.LoadNote(noteId))
  }

  Column(
    modifier
      .padding(vertical = 32.dp, horizontal = 16.dp)
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.primaryContainer),
  ){
    Text(
      maxLines = 1,
      text = state.note.title,
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.titleLarge,
    )
    Spacer(Modifier.size(8.dp))
    Text(
      maxLines = 1,
      text = state.note.date,
      color = MaterialTheme.colorScheme.onPrimary,
    )
    Spacer(Modifier.size(16.dp))
    Text(
      text = state.note.description,
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.bodyLarge,
    )
  }
}