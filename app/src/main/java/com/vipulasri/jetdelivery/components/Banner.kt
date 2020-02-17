package com.vipulasri.jetdelivery.components

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.themeTypography

@Composable
fun showBannerElement(item: Dashboard.Item.SubItem) {
    Container(width = 150.dp, height = 178.dp) {
        Clip(shape = RoundedCornerShape(5.dp)) {
            DrawImage(image = imageResource(id = R.drawable.placeholder_banner))
            item.title?.let {
                Align(alignment = Alignment.BottomLeft) {
                    Container(
                        modifier = LayoutWidth.Fill, height = 50.dp,
                        alignment = Alignment.CenterLeft
                    ) {
                        DrawShape(shape = RectangleShape, color = Color.Black.copy(alpha = 0.3f))
                        Text(
                            text = it,
                            style = themeTypography.caption.copy(color = Color.White),
                            modifier = LayoutPadding(10.dp)
                        )
                    }
                }
            }
        }
    }
}