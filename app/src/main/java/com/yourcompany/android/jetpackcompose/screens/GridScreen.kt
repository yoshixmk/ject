package com.yourcompany.android.jetpackcompose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yourcompany.android.jetpackcompose.R
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen

private val items = listOf(
  Icons.Filled.Check,
  Icons.Filled.Close,
  Icons.Filled.ThumbUp,
  Icons.Filled.Build,
  Icons.Filled.Delete,
  Icons.Filled.Home,
  Icons.Filled.Close,
  Icons.Filled.ThumbUp,
  Icons.Filled.Build,
  Icons.Filled.ThumbUp,
)

@Composable
fun GridScreen() {
  LazyVerticalGrid(
    columns = GridCells.Fixed(3),
    modifier = Modifier.fillMaxSize(),
    content = {
      items(items.size) { index ->
        GridIcon(iconResource = items[index])
      }
    }
  )

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun GridIcon(iconResource: ImageVector) {
  Icon(
    imageVector = iconResource,
    tint = colorResource(R.color.colorPrimary),
    contentDescription = stringResource(R.string.grid_icon),
    modifier = Modifier
      .size(80.dp)
      .padding(20.dp)
  )
}