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
                Color(parseColor(color))
            } ?: Color.Blue
            DrawShape(shape = RectangleShape, color = bgColor)
            Container(width = 40.dp, height = 40.dp) {
                DrawImage(
                    image = imageResource(id = R.drawable.placeholder_category),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
private fun categoryInfo(title: String?, subTitle: String?) {
    title?.let {
        Text(
            text = it,
            style = themeTypography.body2
        )
    }
    subTitle?.let {
        Text(
            text = it,
            style = themeTypography.overline.copy(color = Color.Gray)
        )
    }
}

@ColorInt
fun parseColor(@Size(min = 1) colorString: String): Int {
    if (colorString[0] == '#') { // Use a long to avoid rollovers on #ffXXXXXX
        var color = colorString.substring(1).toLong(16)
        if (colorString.length == 7) { // Set the alpha value
            color = color or -0x1000000
        } else require(colorString.length == 9) { "Unknown color" }
        return color.toInt()
    }
    throw IllegalArgumentException("Unknown color")
}
