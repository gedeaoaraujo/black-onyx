package com.example.blackonyx.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blackonyx.domain.Note

@Composable
fun ListItem(
  modifier: Modifier = Modifier,
  item: Note
) {
  Column(
    modifier
      .padding(16.dp)
      .background(MaterialTheme.colorScheme.primaryContainer)
  ){
    Text(
      maxLines = 1,
      text = item.title,
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.titleMedium,
    )
    Text(
      maxLines = 1,
      text = item.date,
      color = MaterialTheme.colorScheme.onPrimary,
    )
    Text(
      maxLines = 3,
      text = item.description,
      color = MaterialTheme.colorScheme.onPrimary,
      style = MaterialTheme.typography.bodyLarge,
    )
  }
}