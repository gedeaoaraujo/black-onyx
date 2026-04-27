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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackonyx.NotesIntent
import com.example.blackonyx.NotesState
import com.example.blackonyx.NotesViewModel
import com.example.blackonyx.WhiteBlue

@Composable
fun PasswordScreen(
  state: NotesState,
  modifier: Modifier,
  viewModel: NotesViewModel,
  onCheckPressed: () -> Unit
) {
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
        value = state.password,
        onValueChange = {
          viewModel.onAction(NotesIntent.UpdatePassword(it))
        },
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
      if (state.showPasswordError) {
        Spacer(Modifier.size(16.dp))
        Text("A senha está incorreta", color = MaterialTheme.colorScheme.error)
      }
      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "1")) }
        ) { Text("1", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "2")) }
        ) { Text("2", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "3")) }
        ) { Text("3", color = MaterialTheme.colorScheme.onPrimary) }
      }

      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "4")) }
        ) { Text("4", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "5")) }
        ) { Text("5", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "6")) }
        ) { Text("6", color = MaterialTheme.colorScheme.onPrimary) }
      }

      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "7")) }
        ) { Text("7", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "8")) }
        ) { Text("8", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "9")) }
        ) { Text("9", color = MaterialTheme.colorScheme.onPrimary) }
      }

      Spacer(Modifier.size(16.dp))
      Row {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "#")) }
        ) { Text("#", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(state.password + "0")) }
        ) { Text("0", color = MaterialTheme.colorScheme.onPrimary) }

        Spacer(Modifier.size(16.dp))
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = { viewModel.onAction(NotesIntent.UpdatePassword(
            state.password.dropLast(1)
          )) }
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
          onClick = { onCheckPressed() }
        ) { Icon(
          Icons.Default.Check,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.onPrimary
        ) }
      }
    }
  }
}