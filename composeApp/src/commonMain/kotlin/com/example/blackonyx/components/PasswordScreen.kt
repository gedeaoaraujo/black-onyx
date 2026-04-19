package com.example.blackonyx.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackonyx.NotesViewModel
import com.example.blackonyx.WhiteBlue

@Composable
fun PasswordScreen(
  modifier: Modifier,
  viewModel: NotesViewModel,
  onBackPressed: () -> Boolean
) {
  var password by remember { mutableStateOf("") }

  Box(Modifier
    .fillMaxSize()
    .background(MaterialTheme.colorScheme.primary)
  ) {
    Column(
      modifier = modifier.fillMaxSize().background(
        MaterialTheme.colorScheme.primary
      ),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
    ) {
      Text(
        "Black Onyx",
        fontSize = 30.sp,
        color = MaterialTheme.colorScheme.onPrimary,
      )
      Spacer(Modifier.size(32.dp))
      Text("Digite a sua senha", color = MaterialTheme.colorScheme.onPrimary)
      Spacer(Modifier.size(8.dp))
      TextField(
        value = password,
        onValueChange = { password = it },
        modifier = Modifier
          .size(width = 200.dp, height = 50.dp)
          .background(MaterialTheme.colorScheme.primary)
          .border(1.dp, MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(10)),
        colors = TextFieldDefaults.colors(
          cursorColor = MaterialTheme.colorScheme.onPrimary,
          focusedTextColor = MaterialTheme.colorScheme.onPrimary,
          unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
          selectionColors = TextSelectionColors(WhiteBlue, WhiteBlue),
          focusedContainerColor = MaterialTheme.colorScheme.primary,
          unfocusedContainerColor = MaterialTheme.colorScheme.primary,
          focusedIndicatorColor = MaterialTheme.colorScheme.primary,
          unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
        )
      )
      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "1" }
        ) { Text("1", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "2" }
        ) { Text("2", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "3" }
        ) { Text("3", color = MaterialTheme.colorScheme.onPrimary) }
      }
      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "4" }
        ) { Text("4", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "5" }
        ) { Text("5", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "6" }
        ) { Text("6", color = MaterialTheme.colorScheme.onPrimary) }
      }
      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "7" }
        ) { Text("7", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "8" }
        ) { Text("8", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "9" }
        ) { Text("9", color = MaterialTheme.colorScheme.onPrimary) }
      }
      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "#" }
        ) { Text("#", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password += "0" }
        ) { Text("0", color = MaterialTheme.colorScheme.onPrimary) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { password = password.dropLast(1) }
        ) { Icon(
          Icons.AutoMirrored.Default.Backspace,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.onPrimary
        ) }
      }
      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = {}
        ) { Icon(
          Icons.Default.Fingerprint,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.onPrimary
        ) }
        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = {}
        ) { Icon(
          Icons.Default.Check,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.onPrimary
        ) }
      }
    }
  }
}