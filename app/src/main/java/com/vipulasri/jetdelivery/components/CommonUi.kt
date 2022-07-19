package com.vipulasri.jetdelivery.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ShowError(message: String, onRetry: () -> Unit) {
    Column {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = message,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onRetry
        ) {
            Text(stringResource(id = R.string.retry))
        }
    }
}

@Composable
fun ShowVerticalDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = Color.LightGray.copy(alpha = 0.2f)
    )
}

@Preview
@Composable
private fun ShowErrorPreview() {
    ShowError(
        message = "Error Message\nSomething went wrong!",
        onRetry = { })
}
