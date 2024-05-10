package com.yourcompany.android.jetpackcompose.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yourcompany.android.jetpackcompose.R
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen

@Composable
fun ScrollingScreen() {
  MyScrollingScreen()

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun MyScrollingScreen() {
  Row(
    modifier = Modifier.horizontalScroll(rememberScrollState())
  ) {
    BookImage(
      imageResId = R.drawable.advanced_architecture_android,
      contentDescriptionResId = R.string.advanced_architecture_android
    )
    BookImage(
      imageResId = R.drawable.kotlin_aprentice,
      contentDescriptionResId = R.string.kotlin_apprentice
    )
    BookImage(
      imageResId = R.drawable.kotlin_coroutines,
      contentDescriptionResId = R.string.kotlin_coroutines
    )
  }
  // Column(
  //   modifier = Modifier.verticalScroll(rememberScrollState())
  // ) {
  //   BookImage(
  //     imageResId = R.drawable.advanced_architecture_android,
  //     contentDescriptionResId = R.string.advanced_architecture_android
  //   )
  //   BookImage(
  //     imageResId = R.drawable.kotlin_aprentice,
  //     contentDescriptionResId = R.string.kotlin_apprentice
  //   )
  //   BookImage(
  //     imageResId = R.drawable.kotlin_coroutines,
  //     contentDescriptionResId = R.string.kotlin_coroutines
  //   )
  // }
}

@Composable
fun BookImage(@DrawableRes imageResId: Int, @StringRes contentDescriptionResId: Int) {
  Image(
    bitmap = ImageBitmap.imageResource(imageResId),
    contentDescription = stringResource(contentDescriptionResId),
    contentScale = ContentScale.FillBounds,
    modifier = Modifier.size(476.dp, 616.dp)
  )
}