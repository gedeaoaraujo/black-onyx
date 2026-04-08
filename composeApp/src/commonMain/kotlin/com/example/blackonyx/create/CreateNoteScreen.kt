package com.example.blackonyx.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.blackonyx.WhiteBlue
import com.example.blackonyx.create.CreateNoteIntent.UpdateText
import com.example.blackonyx.create.CreateNoteIntent.UpdateTitle

@Composable
fun CreateNoteScreen(
  modifier: Modifier = Modifier,
  onCreateNewNote: () -> Unit = {},
  viewModel: CreateNoteViewModel = viewModel()
) {
  val state by viewModel.state.collectAsStateWithLifecycle()

  DisposableEffect(Unit){
    onDispose {
      viewModel.onAction(CreateNoteIntent.CreateNote)
      onCreateNewNote()
    }
  }

  Column(
    modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .background(MaterialTheme.colorScheme.primaryContainer)
      .padding(vertical = 32.dp, horizontal = 16.dp),
  ) {
    TextField(
      maxLines = 2,
      value = state.title,
      placeholder = { Text("Title") },
      onValueChange = { value ->
        viewModel.onAction(UpdateTitle(value))
      },
      textStyle = MaterialTheme.typography.titleLarge,
      modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primaryContainer),
      colors = TextFieldDefaults.colors(
        cursorColor = MaterialTheme.colorScheme.onPrimary,
        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
        selectionColors = TextSelectionColors(WhiteBlue, WhiteBlue),
        focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        focusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
      )
    )
    Spacer(Modifier.size(16.dp))
    Text(
      maxLines = 1,
      text = state.date,
      color = MaterialTheme.colorScheme.onPrimary,
      modifier = Modifier.padding(horizontal = 16.dp)
    )
    Spacer(Modifier.size(16.dp))
    TextField(
      value = state.text,
      placeholder = { Text("Some text") },
      onValueChange = { value -> viewModel.onAction(UpdateText(value)) },
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer),
      colors = TextFieldDefaults.colors(
        cursorColor = MaterialTheme.colorScheme.onPrimary,
        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
        selectionColors = TextSelectionColors(WhiteBlue, WhiteBlue),
        focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        focusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
      )
    )
  }
}