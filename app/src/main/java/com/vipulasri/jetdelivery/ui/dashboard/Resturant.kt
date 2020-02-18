package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.Composable
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.dimensionResource
import androidx.ui.res.imageResource
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.VectorImage
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.themeTypography

@Composable
fun showRestaurantElement(item: Dashboard.Item.SubItem) {
    Ripple(bounded = true) {
        Padding(padding = dimensionResource(id = R.dimen.padding)) {
            Row {
                restaurantImage(url = item.imageUrl)
                Column(
                    modifier = LayoutFlexible(1f)
                        .plus(
                            LayoutPadding(
                                left = dimensionResource(id = R.dimen.padding),
                                right = dimensionResource(id = R.dimen.padding)
                            )
                        ).plus(
                            LayoutGravity.Center
                        )
                ) {
                    restaurantInfo(item = item)
                }
            }
        }
    }
}

@Composable
private fun restaurantImage(url: String?) {
    Container(width = 70.dp, height = 70.dp) {
        Clip(shape = RoundedCornerShape(5.dp)) {
            DrawImage(image = imageResource(id = R.drawable.placeholder_restaurant))
        }
    }
}

@Composable
private fun restaurantInfo(item: Dashboard.Item.SubItem) {
    val title = item.title ?: "Name"
    val subTitle = item.subTitle ?: "Caption"
    val rating = "${item.meta?.rating}" ?: "4.0"
    val reviewCount = "${item.meta?.reviewCount}" ?: "500+ reviews"

    Text(text = title)
    Text(
        text = subTitle,
        style = themeTypography.caption.copy(color = Color.Gray)
    )

    Row(modifier = LayoutAlign.CenterVertically) {
        VectorImage(
            id = R.drawable.ic_round_star_24,
            tint = Color(0xFFF5CE47),
            size = LayoutSize(16.dp, 16.dp)
        )

        Spacer(modifier = LayoutWidth(4.dp))

        Text(text = AnnotatedString {
            append(rating)
            pushStyle(SpanStyle(color = Color.Gray))
            append(" ( $reviewCount reviews)")
            popStyle()
        }, style = themeTypography.caption)
    }
}
