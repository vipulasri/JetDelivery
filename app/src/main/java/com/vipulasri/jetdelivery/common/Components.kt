package com.vipulasri.jetdelivery.common

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R


@Composable
fun AppTopBar(name: String) {
    TopAppBar(
        color = Color.White,
        title = { Text (text = name) }
    )
}

@Composable
fun showLoading() {
    Center {
        CircularProgressIndicator()
    }
}

@Composable
fun showError(message: String, onRetry: () -> Unit) {
    Center {
        Column {
            Text(
                modifier = LayoutWidth.Fill,
                text = message,
                style = TextStyle(textAlign = TextAlign.Center)
            )
            Spacer(modifier = LayoutHeight(20.dp))
            Button(
                stringResource(id = R.string.retry),
                onClick = onRetry,
                modifier = LayoutGravity.Center)
        }
    }
}


@Preview
@Composable
private fun showErrorPreview() {
    showError(
        message = "Error Message\nSomething went wrong!",
        onRetry = { } )
}