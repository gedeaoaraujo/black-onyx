package com.example.blackonyx

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackonyx.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun RootComponent() {
  BlackOnyxTheme {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("Black Onyx") },
          colors = TopAppBarDefaults.topAppBarColors().copy(
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.primary,
          )
        )
      },
      floatingActionButton = {
        FloatingActionButton(
          containerColor = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(60.dp),
          shape = CircleShape,
          onClick = {}
        ){
          Text("+", color = MaterialTheme.colorScheme.onPrimary)
        }
      }
    ) { innerPadding ->
      HomeScreen(Modifier.padding(innerPadding))
    }
  }
}