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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigationevent.NavigationEventInfo
import androidx.navigationevent.compose.NavigationBackHandler
import androidx.navigationevent.compose.rememberNavigationEventState
import com.example.blackonyx.NotesIntent
import com.example.blackonyx.NotesViewModel
import com.example.blackonyx.WhiteBlue

@Composable
fun CreateNoteScreen(
  modifier: Modifier = Modifier,
  onBackPressed: () -> Unit = {},
  viewModel: NotesViewModel,
) {
  val state by viewModel.state.collectAsStateWithLifecycle()
  val navEventState = rememberNavigationEventState(currentInfo = NavigationEventInfo.None)

  NavigationBackHandler(
    state = navEventState,
    isBackEnabled = true,
    onBackCompleted = {
      viewModel.onAction(NotesIntent.ToggleDialog)
    }
  )

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
        viewModel.onAction(NotesIntent.UpdateTitle(value))
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
      onValueChange = { value ->
        viewModel.onAction(NotesIntent.UpdateText(value))
      },
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

    if (state.showDialog){
      AlertDialog(
        title = { Text("Mensagem") },
        onDismissRequest = {},
        text = { Text("Você deseja voltar e descartar todas as alterações?") },
        confirmButton = {
          TextButton(onClick = onBackPressed) { Text("Sim") }
        },
        dismissButton = {
          TextButton(onClick = {
            viewModel.onAction(NotesIntent.ToggleDialog)
          }) { Text("Não") }
        }
      )
    }
  }
}