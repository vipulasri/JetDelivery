package com.vipulasri.jetdelivery.components

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.dimensionResource
import androidx.ui.res.stringResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.ui.themeTypography

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
fun showHeader(title: String, hasMore: Boolean) {
    Row(
        modifier = LayoutPadding(
            top = 5.dp,
            left = dimensionResource(id = R.dimen.padding),
            right = dimensionResource(id = R.dimen.padding),
            bottom = 5.dp
        )
    ) {
        Text(modifier = LayoutFlexible(1f).plus(LayoutGravity.Center),
            text = title,
            style = themeTypography.h6)
        if(hasMore) {
            Button(
                style = TextButtonStyle()
            ) {
                Ripple(bounded = false) {
                    Text(modifier = LayoutGravity.Center,
                        text = "View All",
                        style = themeTypography.caption)
                }
            }
        }
    }
}

@Composable
fun showVerticalDivider() {
    Divider(modifier = LayoutPadding(
        left = dimensionResource(id = R.dimen.padding),
        right = dimensionResource(id = R.dimen.padding)),
        color = Color.LightGray.copy(alpha = 0.2f))
}

@Composable
fun VectorImage(modifier: Modifier = Modifier.None, @DrawableRes id: Int, tint: Color = Color.Transparent, size: LayoutSize? = null) {
    val vector = vectorResource(id)
    WithDensity {
        val layoutSize = size?: LayoutSize(vector.defaultWidth, vector.defaultHeight)
        Container(
            modifier = modifier + layoutSize
        ) {
            DrawVector(vector, tint)
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