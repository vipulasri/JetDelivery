package com.vipulasri.jetdelivery.ui

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.dimensionResource
import androidx.ui.res.stringResource
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.common.*
import com.vipulasri.jetdelivery.data.Result
import com.vipulasri.jetdelivery.data.observe
import com.vipulasri.jetdelivery.network.model.Dashboard
import com.vipulasri.jetdelivery.ui.main.MainViewModel

@Composable
fun JetDeliveryApp(viewModel: MainViewModel) {
    MaterialTheme(colors = lightThemeColors) {
        Scaffold(topAppBar = {
            AppTopBar(name = stringResource(id = R.string.app_name))
        }) {
            when (val data = observe(data = viewModel.dashboardItems)) {
                is Result.Loading -> {
                    showLoading()
                }
                is Result.Success -> {
                    showData(data = data.data ?: emptyList())
                }
                is Result.Failure -> {
                    showError(
                        message = data.error.message ?: "",
                        onRetry = { viewModel.loadData() })
                }
            }
        }
    }
}

@Composable
private fun showData(data: List<Dashboard.Item>) {
    VerticalScroller {
        Column(
            modifier = LayoutPadding(
                top = dimensionResource(id = R.dimen.padding),
                bottom = dimensionResource(id = R.dimen.padding)
            )
        ) {
            data.forEachIndexed { index, item ->
                when (item.viewType) {
                    "horizontalScroll" -> showHorizontalElements(item = item)
                    "verticalScroll" -> showVerticalElements(item = item)
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
                "bannerElement" -> showBannerElement(item = data)
                "categoryElement" -> showCategoryElement(item = data)
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
            "restaurantElement" -> showRestaurantElement(item = data)
        }
        if (index != item.data.size) showVerticalDivider()
    }
}
