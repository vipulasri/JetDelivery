package com.vipulasri.jetdelivery.components

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.dimensionResource
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R

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

@Composable
fun horizontalScroll(modifier: Modifier = Modifier.None, children: @Composable() RowScope.() -> Unit) {
    HorizontalScroller(modifier = modifier) {
        Row(
            modifier = LayoutPadding(
                left = dimensionResource(id = R.dimen.padding),
                right = dimensionResource(id = R.dimen.padding)
            ),
            children = children
        )
    }
}

@Composable
fun showVerticalDivider() {
    Divider(modifier = LayoutPadding(
        left = dimensionResource(id = R.dimen.padding),
        right = dimensionResource(id = R.dimen.padding)),
        color = Color.LightGray.copy(alpha = 0.2f))
}

@Preview
@Composable
private fun showErrorPreview() {
    showError(
        message = "Error Message\nSomething went wrong!",
        onRetry = { })
}
