package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.PrimaryText

@Composable
fun ShowHeader(title: String, hasMore: Boolean) {
    Row(
        modifier = Modifier.padding(
            horizontal = dimensionResource(id = R.dimen.padding),
            vertical = 5.dp
        )
    ) {
        PrimaryText {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = title,
                style = MaterialTheme.typography.h6
            )
        }

        if (hasMore) {
            TextButton(
                onClick = {

                }
            ) {
                Text(
                    modifier = Modifier,
                    text = "View All",
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.W600)
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHeader() {
    ShowHeader(title = "Popular Restaurants Near You", hasMore = true)
}