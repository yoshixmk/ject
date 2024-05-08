package com.yourcompany.android.jetpackcompose.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.yourcompany.android.jetpackcompose.R
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen
import kotlinx.coroutines.CoroutineScope

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
  //TODO write your code here
}

@Composable
fun MyBottomAppBar() {
  //TODO write your code here
}
