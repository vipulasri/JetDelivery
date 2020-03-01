package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.res.dimensionResource
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.*
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.network.model.ItemViewType
import com.vipulasri.jetdelivery.network.model.SubItemViewType

@Composable
fun showDashboard(data: List<Dashboard.Item>) {
    VerticalScroller {
        Column(
            modifier = LayoutPadding(
                top = dimensionResource(id = R.dimen.padding),
                bottom = dimensionResource(id = R.dimen.padding)
            )
        ) {
            data.forEachIndexed { index, item ->
                when (item.viewType) {
                    ItemViewType.HorizontalScroll -> showHorizontalElements(
                        item = item
                    )
                    ItemViewType.VerticalScroll -> showVerticalElements(
                        item = item
                    )
                }
                if (index != item.data.size) Spacer(modifier = LayoutHeight(10.dp))
            }
        }
    }
}

private fun showHorizontalElements(item: Dashboard.Item) {
    item.header?.let {
        showHeader(title = it.title, hasMore = it.hasMore)
    }
    horizontalScroll {
        item.data.forEachIndexed { index, data ->
            when (data.viewType) {
                SubItemViewType.Banner -> showBannerElement(
                    item = data
                )
                SubItemViewType.Category -> showCategoryElement(
                    item = data
                )
            }
            if (index != item.data.size) Spacer(modifier = LayoutWidth(10.dp))
        }
    }
}

private fun showVerticalElements(item: Dashboard.Item) {
    item.header?.let {
        showHeader(title = it.title, hasMore = it.hasMore)
    }
    item.data.forEachIndexed { index, data ->
        when (data.viewType) {
            SubItemViewType.Restaurant -> showRestaurantElement(
                item = data
            )
        }
        if (index != item.data.size) showVerticalDivider()
    }
}
