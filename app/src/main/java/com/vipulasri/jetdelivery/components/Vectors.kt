package com.vipulasri.jetdelivery.components

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.WithDensity
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.res.vectorResource

@Composable
fun VectorImage(modifier: Modifier = Modifier.None, @DrawableRes id: Int, tint: Color = Color.Transparent, size: LayoutSize? = null) {
    val vector = vectorResource(id)
    WithDensity {
        val layoutSize = size ?: LayoutSize(vector.defaultWidth, vector.defaultHeight)
        Container(
            modifier = modifier + layoutSize
        ) {
            DrawVector(vector, tint)
        }
    }
}