package com.example.blackonyx

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Dark = Color(0xFF000000)
val DarkBlue = Color(0xFF000028)
val WhiteBlue = Color(0xFF00003C)

val LightScheme = lightColorScheme(
  primary = DarkBlue,
  secondary = WhiteBlue,
  primaryContainer = Dark,
)

@Composable
fun BlackOnyxTheme(
  isDarkTheme: Boolean = false,
  content: (@Composable () -> Unit)
){
  val colorScheme = if (isDarkTheme){
    LightScheme
  } else {
    LightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}