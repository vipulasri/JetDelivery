package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.LayoutGravity
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Row
import androidx.ui.material.Button
import androidx.ui.material.TextButtonStyle
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.dimensionResource
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.ui.themeTypography

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
        if (hasMore) {
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