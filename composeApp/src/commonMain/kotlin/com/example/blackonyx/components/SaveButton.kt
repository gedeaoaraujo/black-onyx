package com.example.blackonyx.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.blackonyx.NotesState


@Composable
fun SaveButton(state: NotesState, onClick: () -> Unit) {
  IconButton(enabled = state.clickableCheck, onClick = onClick) {
    Icon(
      contentDescription = "Save Note",
      imageVector = Icons.Default.Check,
      tint = if (state.clickableCheck) {
        MaterialTheme.colorScheme.onPrimary
      } else Color.DarkGray
    )
  }
}