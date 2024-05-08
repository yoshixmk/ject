package com.yourcompany.android.jetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.yourcompany.android.jetpackcompose.R
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen

val THREE_ELEMENT_LIST = listOf(R.string.first, R.string.second, R.string.third)

@Composable
fun RowScreen() {
  MyRow()

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun MyRow(modifier: Modifier = Modifier) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxSize(),
  ) {
    THREE_ELEMENT_LIST.forEach { textId ->
      Text(
        text = stringResource(id = textId),
        fontSize = 18.sp
      )
    }
  }
}