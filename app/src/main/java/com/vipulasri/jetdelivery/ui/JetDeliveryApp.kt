package com.vipulasri.jetdelivery.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.dimensionResource
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.common.AppTopBar
import com.vipulasri.jetdelivery.common.showBanner
import com.vipulasri.jetdelivery.common.showError
import com.vipulasri.jetdelivery.common.showLoading
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
            when(val data = observe(data = viewModel.dashboardItems)) {
                is Result.Loading -> {
                    showLoading()
                }
                is Result.Success -> {
                    showData(data = data.data?: emptyList())
                }
                is Result.Failure -> {
                    showError(message = data.error.message?: "", onRetry = { viewModel.loadData() })
                }
            }
        }
    }
}

@Composable
private fun showData(data: List<Dashboard.Item>) {
    VerticalScroller {
        Column(modifier = LayoutPadding(top = dimensionResource(id = R.dimen.padding), bottom = dimensionResource(id = R.dimen.padding))) {
            data.forEach { item ->
                if(item.viewType == "bannerScroll") {
                    showBanner(item = item)
                }
            }
        }
    }
}
