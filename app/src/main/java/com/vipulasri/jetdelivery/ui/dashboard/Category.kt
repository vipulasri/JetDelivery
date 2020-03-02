package com.vipulasri.jetdelivery.ui.dashboard

import androidx.annotation.ColorInt
import androidx.annotation.Size
import androidx.compose.Composable
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.Spacer
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.image
import com.vipulasri.jetdelivery.components.primaryText
import com.vipulasri.jetdelivery.components.secondaryText
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.themeTypography

@Composable
fun showCategoryElement(item: Dashboard.Item.SubItem) {
    Column {
        Spacer(modifier = LayoutHeight(5.dp)) // added to support space for header
        Ripple(bounded = true) {
            categoryImage(item = item)
        }
        Spacer(modifier = LayoutHeight(5.dp))
        categoryInfo(
            title = item.title,
            subTitle = item.subTitle
        )
    }
}

@Composable
private fun categoryImage(item: Dashboard.Item.SubItem) {
    Container(width = 70.dp, height = 70.dp) {
        Clip(shape = RoundedCornerShape(5.dp)) {
            val bgColor = item.meta?.bgColor?.let { color ->
                getColor(color)
            } ?: Color.Blue
            DrawShape(shape = RectangleShape, color = bgColor)
            Container(width = 40.dp, height = 40.dp) {
                DrawImage(
                    image = image(item.imageUrl)
                        ?: imageResource(id = R.drawable.placeholder_category),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun categoryInfo(title: String?, subTitle: String?) {
    title?.let {
        primaryText {
            Text(
                text = it,
                style = themeTypography.subtitle2
            )
        }
    }
    subTitle?.let {
        secondaryText {
            Text(
                text = it,
                style = themeTypography.overline
            )
        }
    }
}

fun getColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}