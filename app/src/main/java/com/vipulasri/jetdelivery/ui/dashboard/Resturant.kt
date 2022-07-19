package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.LoadImage
import com.vipulasri.jetdelivery.components.PrimaryText
import com.vipulasri.jetdelivery.components.SecondaryText
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.themeTypography

@Composable
fun ShowRestaurantElement(item: Dashboard.Item.SubItem) {
    Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding))) {
        RestaurantImage(url = item.imageUrl)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(id = R.dimen.padding))
                .align(Alignment.CenterVertically)
        ) {
            RestaurantInfo(item = item)
        }
    }
}

@Composable
private fun RestaurantImage(url: String) {
    LoadImage(
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(5.dp)),
        image = url
    )
}

@Composable
private fun RestaurantInfo(item: Dashboard.Item.SubItem) {
    val title = item.title ?: "Name"
    val subTitle = item.subTitle ?: "Caption"
    val rating = "${item.meta?.rating}" ?: "4.0"
    val reviewCount = "${item.meta?.reviewCount}" ?: "500+ reviews"

    PrimaryText {
        Text(
            text = title,
            style = themeTypography.subtitle1
        )
    }

    SecondaryText {
        Text(
            text = subTitle,
            style = themeTypography.caption
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            contentDescription = "",
            painter = painterResource(id = R.drawable.ic_round_star_24),
            tint = Color(0xFFF5CE47)
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = buildAnnotatedString {
                append(rating)
                pushStyle(SpanStyle(color = Color.Gray))
                append(" ( $reviewCount reviews)")
                pop()
            }, style = MaterialTheme.typography.caption
        )

        Text(
            modifier = Modifier
                .background(MaterialTheme.colors.primary, RoundedCornerShape(100.dp))
                .padding(horizontal = 5.dp, vertical = 2.dp),
            text = stringResource(id = R.string.free_delivery),
            color = Color.White,
            style = MaterialTheme.typography.overline
        )
    }
}
