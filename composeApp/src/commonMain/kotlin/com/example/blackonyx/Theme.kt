package com.example.blackonyx

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Dark = Color(0xFF000000)
val DarkBlue = Color(0xFF000028)
val WhiteBlue = Color(0xFF00003C)

val DarkScheme = lightColorScheme(
  primary = DarkBlue,
  secondary = WhiteBlue,
  primaryContainer = Dark,
)

val LightScheme = lightColorScheme(
  primary = DarkBlue,
  onSecondary = Dark,
  secondary = WhiteBlue,
  primaryContainer = Color.White,
)

@Composable
fun BlackOnyxTheme(
  isDarkTheme: Boolean = true,
  content: (@Composable () -> Unit)
){
  val colorScheme = if (isDarkTheme){
    DarkScheme
  } else {
    LightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}