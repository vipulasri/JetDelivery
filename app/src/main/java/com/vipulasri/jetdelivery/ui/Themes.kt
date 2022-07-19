package com.vipulasri.jetdelivery.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightThemeColors = lightColors(
    primary = Color(0xFFFF8C29),
    primaryVariant = Color(0xFFF87D27),
    secondary = Color(0xFFFF2D55),
    secondaryVariant = Color(0xFFFF0038),
    error = Color(0xFFD00036)
)

@Composable
fun JetDeliveryTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = lightThemeColors,
        typography = themeTypography,
        content = content
    )
}