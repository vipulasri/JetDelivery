package com.vipulasri.jetdelivery.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import com.vipulasri.jetdelivery.ui.home.HomeScreen

@Composable
fun JetDeliveryApp() {
    MaterialTheme(colors = lightThemeColors) {
        HomeScreen()
    }
}

@Composable
fun AppTopBar(name: String) {
    TopAppBar(
        color = Color.White,
        title = { Text (text = name) }
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
    JetDeliveryApp()
}