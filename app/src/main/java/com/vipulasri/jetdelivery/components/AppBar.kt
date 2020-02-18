package com.vipulasri.jetdelivery.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.material.TopAppBar

@Composable
fun AppTopBar(name: String) {
    TopAppBar(
        color = Color.White,
        title = { Text(text = name) }
    )
}