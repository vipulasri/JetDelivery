package com.vipulasri.jetdelivery.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.ShowVerticalDivider
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.network.model.ItemViewType
import com.vipulasri.jetdelivery.network.model.SubItemViewType

@Composable
fun ShowDashboard(data: List<Dashboard.Item>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.padding))
    ) {
        itemsIndexed(items = data) { index, item ->
            when (item.viewType) {
                ItemViewType.HorizontalScroll -> ShowHorizontalElements(
                    item = item
                )
                ItemViewType.VerticalScroll -> ShowVerticalElements(
                    item = item
                )
            }
            if (index != item.data.size) Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun ShowHorizontalElements(item: Dashboard.Item) {
    item.header?.let {
        ShowHeader(title = it.title, hasMore = it.hasMore)
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.padding))
    ) {
        itemsIndexed(item.data) { index, data ->
            when (data.viewType) {
                SubItemViewType.Banner -> ShowBannerElement(
                    item = data
                )
                SubItemViewType.Category -> ShowCategoryElement(
                    item = data
                )
                else -> {
                    // do nothing
                }
            }
            if (index != item.data.size) Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
private fun ShowVerticalElements(item: Dashboard.Item) {
    item.header?.let {
        ShowHeader(title = it.title, hasMore = it.hasMore)
    }
    item.data.forEachIndexed { index, data ->
        when (data.viewType) {
            SubItemViewType.Restaurant -> ShowRestaurantElement(
                item = data
            )
            else -> {
                // do nothing
            }
        }
        if (index != item.data.size) ShowVerticalDivider()
    }
}
