package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Align
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.image
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.themeTypography

@Composable
fun showBannerElement(item: Dashboard.Item.SubItem) {
    Ripple(bounded = true) {
        Container(width = 150.dp, height = 178.dp) {
            Clip(shape = RoundedCornerShape(5.dp)) {
                bannerImage(url = item.imageUrl)
                item.title?.let {
                    bannerText(title = it)
                }
            }
        }
    }
}


@Composable
private fun bannerImage(url: String) {
    image(url)?.let {
        DrawImage(it)
    }?: DrawImage(image = imageResource(id = R.drawable.placeholder_banner))
}

@Composable
private fun bannerText(title: String) {
    Align(alignment = Alignment.BottomLeft) {
        Container(
            modifier = LayoutWidth.Fill, height = 50.dp,
            alignment = Alignment.CenterLeft
        ) {
            DrawShape(shape = RectangleShape, color = Color.Black.copy(alpha = 0.3f))
            Text(
                text = title,
                style = themeTypography.subtitle2.copy(color = Color.White, fontSize = 12.sp),
                modifier = LayoutPadding(10.dp)
            )
        }
    }
}