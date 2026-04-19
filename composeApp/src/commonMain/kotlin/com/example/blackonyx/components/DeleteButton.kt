package com.example.blackonyx.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun DeleteButton(onClick: () -> Unit) {
  IconButton(onClick = onClick) {
    Icon(
      contentDescription = "Delete Note",
      imageVector = Icons.Default.Delete,
      tint = MaterialTheme.colorScheme.onPrimary
    )
  }
}