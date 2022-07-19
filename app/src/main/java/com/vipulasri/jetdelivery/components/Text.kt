package com.vipulasri.jetdelivery.components

import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun PrimaryText(children: @Composable() () -> Unit) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
        children.invoke()
    }
}

@Composable
fun SecondaryText(children: @Composable() () -> Unit) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        children.invoke()
    }
}

@Composable
fun DisabledText(children: @Composable() () -> Unit) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
        children.invoke()
    }
}