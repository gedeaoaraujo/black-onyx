package com.example.blackonyx.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ThemeButton(isDarkTheme: Boolean, onClick: () -> Unit) {

  fun getThemeIcon(): ImageVector {
    return if (isDarkTheme) {
      Icons.Default.LightMode
    } else Icons.Default.DarkMode
  }

  IconButton(onClick = onClick) {
    Icon(
      imageVector = getThemeIcon(),
      contentDescription = "Toggle Theme",
      tint = MaterialTheme.colorScheme.onPrimary
    )
  }
}