package com.example.blackonyx.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.blackonyx.NotesIntent
import com.example.blackonyx.NotesViewModel

@Composable
fun ViewNoteScreen(
  noteId: Int = 0,
  modifier: Modifier = Modifier,
  viewModel: NotesViewModel
){
  val state by viewModel.state.collectAsStateWithLifecycle()

  LaunchedEffect(Unit){
    viewModel.onAction(NotesIntent.LoadNote(noteId))
  }

  Column(
    modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(MaterialTheme.colorScheme.primaryContainer)
      .padding(vertical = 32.dp, horizontal = 16.dp),
  ){
    Text(
      maxLines = 1,
      text = state.title,
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.titleLarge,
    )
    Spacer(Modifier.size(8.dp))
    Text(
      maxLines = 1,
      text = state.date,
      color = MaterialTheme.colorScheme.onPrimary,
    )
    Spacer(Modifier.size(16.dp))
    Text(
      text = state.text,
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.bodyLarge,
    )
  }
}