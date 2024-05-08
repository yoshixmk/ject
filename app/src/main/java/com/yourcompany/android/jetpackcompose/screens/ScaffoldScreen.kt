package com.yourcompany.android.jetpackcompose.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.yourcompany.android.jetpackcompose.R
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
  MyScaffold()

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun MyScaffold() {
  val scaffoldState: ScaffoldState = rememberScaffoldState()
  val scope: CoroutineScope = rememberCoroutineScope()
  Scaffold(
    scaffoldState = scaffoldState,
    contentColor = colorResource(id = R.color.colorPrimary),
    content = { padding ->
      MyRow(modifier = Modifier.padding(padding))
    },
    topBar = {
      MyTopAppBar(
        scaffoldState = scaffoldState,
        scope = scope
      )
    },
    bottomBar = { MyBottomAppBar() },
    drawerContent = { MyColumn() }
  )
}

@Composable
fun MyTopAppBar(
  scaffoldState: ScaffoldState,
  scope:
  CoroutineScope,
) {
  val drawerState = scaffoldState.drawerState

  TopAppBar(
    title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
    backgroundColor = colorResource(id = R.color.colorPrimary),
    navigationIcon = {
      IconButton(
        onClick = {
          scope.launch {
            if (drawerState.isClosed) {
              drawerState.open()
            } else {
              drawerState.close()
            }
          }
        },
        content = {
          Icon(
            imageVector = Icons.Default.Menu,
            tint = Color.White,
            contentDescription = stringResource(id = R.string.menu)
          )
        }
      )
    }
  )
}

@Composable
fun MyBottomAppBar() {
  BottomAppBar(
    backgroundColor = colorResource(id = R.color.colorPrimary),
    content = { },
  )
}
