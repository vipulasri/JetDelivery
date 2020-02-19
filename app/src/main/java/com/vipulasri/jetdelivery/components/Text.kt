package com.vipulasri.jetdelivery.components

import androidx.compose.Composable
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ProvideEmphasis

@Composable
fun primaryText(children: @Composable() () -> Unit) {
    ProvideEmphasis(emphasis = MaterialTheme.emphasisLevels().high) {
        children.invoke()
    }
}

@Composable
fun secondaryText(children: @Composable() () -> Unit) {
    ProvideEmphasis(emphasis = MaterialTheme.emphasisLevels().medium) {
        children.invoke()
    }
}

@Composable
fun disabledText(children: @Composable() () -> Unit) {
    ProvideEmphasis(emphasis = MaterialTheme.emphasisLevels().disabled) {
        children.invoke()
    }
}