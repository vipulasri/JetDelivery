package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.Composable
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.dimensionResource
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.text.AnnotatedString
import androidx.ui.text.SpanStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.VectorImage
import com.vipulasri.jetdelivery.components.image
import com.vipulasri.jetdelivery.components.primaryText
import com.vipulasri.jetdelivery.components.secondaryText
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.lightThemeColors
import com.vipulasri.jetdelivery.ui.themeTypography

@Composable
fun showRestaurantElement(item: Dashboard.Item.SubItem) {

    //Ripple issue with padding introduced in dev-05, https://issuetracker.google.com/issues/150060763

    Ripple(bounded = true) {
        Row(modifier = LayoutPadding(dimensionResource(id = R.dimen.padding))) {
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

@Composable
private fun restaurantImage(url: String) {
    Container(width = 70.dp, height = 70.dp) {
        Clip(shape = RoundedCornerShape(5.dp)) {
            DrawImage(image = image(url) ?: imageResource(id = R.drawable.placeholder_restaurant))
        }
    }
}

@Composable
private fun restaurantInfo(item: Dashboard.Item.SubItem) {
    val title = item.title ?: "Name"
    val subTitle = item.subTitle ?: "Caption"
    val rating = "${item.meta?.rating}" ?: "4.0"
    val reviewCount = "${item.meta?.reviewCount}" ?: "500+ reviews"

    primaryText {
        Text(
            text = title,
            style = themeTypography.subtitle1
        )
    }

    secondaryText {
        Text(
            text = subTitle,
            style = themeTypography.caption
        )
    }

    Row(modifier = LayoutAlign.CenterVertically) {
        VectorImage(
            id = R.drawable.ic_round_star_24,
            tint = Color(0xFFF5CE47),
            size = LayoutSize(16.dp, 16.dp)
        )

        Spacer(modifier = LayoutWidth(4.dp))

        Row {
            Text(
                modifier = LayoutAlign.CenterVertically.plus(LayoutFlexible(1f)),
                text = AnnotatedString {
                    append(rating)
                    pushStyle(SpanStyle(color = Color.Gray))
                    append(" ( $reviewCount reviews)")
                    popStyle()
                }, style = themeTypography.caption
            )

            Surface(
                color = lightThemeColors.primary,
                shape = RoundedCornerShape(100.dp)
            ) {
                Text(
                    modifier = LayoutPadding(left = 5.dp, top = 2.dp, right = 5.dp, bottom = 2.dp),
                    text = stringResource(id = R.string.free_delivery),
                    style = themeTypography.overline
                )
            }
        }
    }
}
