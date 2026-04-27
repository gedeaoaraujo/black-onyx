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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.blackonyx.Screen.Create
import com.example.blackonyx.Screen.Home
import com.example.blackonyx.Screen.Password
import com.example.blackonyx.Screen.View
import com.example.blackonyx.components.CreateNoteScreen
import com.example.blackonyx.components.DeleteButton
import com.example.blackonyx.components.HomeScreen
import com.example.blackonyx.components.PasswordScreen
import com.example.blackonyx.components.SaveButton
import com.example.blackonyx.components.ThemeButton
import com.example.blackonyx.components.ViewNoteScreen
import kotlinx.serialization.Serializable

const val APP_NAME = "Black Onyx"

@Serializable
sealed class Screen {
  @Serializable object Home : Screen()
  @Serializable object Create : Screen()
  @Serializable object Password : Screen()
  @Serializable data class View(val id: Int) : Screen()
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RootComponent() {
  val navController = rememberNavController()
  val viewModel = viewModel<NotesViewModel>()
  val backStackEntry by navController.currentBackStackEntryAsState()
  val state by viewModel.state.collectAsStateWithLifecycle()

  LaunchedEffect(state.navigateHome){
    if (state.navigateHome){
      navController.navigate(route = Home)
    }
  }

  BlackOnyxTheme(state.isDarkTheme) {
    Scaffold(
      topBar = {
        if (state.showTopBar) TopAppBar(
          title = { Text(APP_NAME) },
          colors = TopAppBarDefaults.topAppBarColors().copy(
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.primary,
          ),
          actions = {
            if (backStackEntry isRoute Home::class){
              ThemeButton(state.isDarkTheme) {
                viewModel.onAction(NotesIntent.ToggleTheme)
              }
            }

            if (backStackEntry isRoute Create::class){
              SaveButton(state, onClick = {
                viewModel.onAction(NotesIntent.SaveNote)
                navController.popBackStack()
              })
            }

            if (backStackEntry isRoute View::class){
              DeleteButton {
                viewModel.onAction(NotesIntent.DeleteNote)
                navController.popBackStack()
              }
            }
          }
        )
      },
      floatingActionButton = {
        if (backStackEntry isRoute Home::class){
          FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            onClick = {
              navController.navigate(route = Create)
            }
          ){
            Text("+", color = MaterialTheme.colorScheme.onPrimary)
          }
        }
      },
      containerColor = MaterialTheme.colorScheme.primaryContainer
    ) { innerPadding ->
      NavHost(
        navController = navController,
        startDestination = Password
      ){
        composable<Password> {
          PasswordScreen(
            state = state,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding),
            onCheckPressed = {
              viewModel.onAction(NotesIntent.CheckPassword)
            }
          )
        }
        composable<Home> {
          HomeScreen(
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding),
            onClickItem = { id ->
              navController.navigate(route = View(id))
            }
          )
        }
        composable<Create> {
          CreateNoteScreen(
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding),
            onBackPressed = navController::navigateUp
          )
        }
        composable<View> { backStackEntry ->
          val view = backStackEntry.toRoute<View>()
          ViewNoteScreen(
            noteId = view.id,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}