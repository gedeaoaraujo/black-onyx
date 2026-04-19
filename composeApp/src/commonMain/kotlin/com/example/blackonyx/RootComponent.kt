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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.blackonyx.components.CreateNoteScreen
import com.example.blackonyx.components.DeleteButton
import com.example.blackonyx.components.HomeScreen
import com.example.blackonyx.components.SaveButton
import com.example.blackonyx.components.ThemeButton
import com.example.blackonyx.components.ViewNoteScreen

const val HOME_SCREEN = "HOME"
const val VIEW_SCREEN = "VIEW"
const val CREATE_SCREEN = "CREATE"
const val APP_NAME = "Black Onyx"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun RootComponent() {
  val navController = rememberNavController()
  val viewModel = viewModel<NotesViewModel>()
  val backStackEntry by navController.currentBackStackEntryAsState()
  val state by viewModel.state.collectAsStateWithLifecycle()

  BlackOnyxTheme(state.isDarkTheme) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text(APP_NAME) },
          colors = TopAppBarDefaults.topAppBarColors().copy(
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.primary,
          ),
          actions = {
            if (backStackEntry isRoute HOME_SCREEN){
              ThemeButton {
                viewModel.onAction(NotesIntent.ToggleTheme)
              }
            }

            if (backStackEntry isRoute CREATE_SCREEN){
              SaveButton(state, onClick = {
                viewModel.onAction(NotesIntent.SaveNote)
                navController.popBackStack()
              })
            }

            if (backStackEntry isRoute "$VIEW_SCREEN/{id}"){
              DeleteButton {
                viewModel.onAction(NotesIntent.DeleteNote)
                navController.popBackStack()
              }
            }
          }
        )
      },
      floatingActionButton = {
        if (backStackEntry isRoute HOME_SCREEN){
          FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            onClick = {
              navController.navigate(CREATE_SCREEN)
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
        startDestination = HOME_SCREEN
      ){
        composable(HOME_SCREEN) {
          HomeScreen(
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding),
            onClickItem = { id -> navController.navigate("$VIEW_SCREEN/$id") }
          )
        }
        composable(CREATE_SCREEN) {
          CreateNoteScreen(
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding),
            onBackPressed = navController::navigateUp
          )
        }
        composable(
          route = "$VIEW_SCREEN/{id}",
          arguments = listOf(navArgument("id") {
            type = NavType.IntType
          })
        ) { backStackEntry ->
          val noteId = backStackEntry.savedStateHandle.get<Int>("id")?:0
          ViewNoteScreen(
            noteId = noteId,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}