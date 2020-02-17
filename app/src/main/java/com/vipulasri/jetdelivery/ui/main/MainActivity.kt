package com.vipulasri.jetdelivery.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.res.stringResource
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.components.AppTopBar
import com.vipulasri.jetdelivery.components.showError
import com.vipulasri.jetdelivery.components.showLoading
import com.vipulasri.jetdelivery.data.Result
import com.vipulasri.jetdelivery.data.observe
import com.vipulasri.jetdelivery.ui.lightThemeColors
import com.vipulasri.jetdelivery.ui.showDashboard
import com.vipulasri.jetdelivery.ui.themeTypography

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.loadData()

    setContent {
      JetDeliveryApp(viewModel)
    }
  }
}


@Composable
fun JetDeliveryApp(viewModel: MainViewModel) {
  MaterialTheme(colors = lightThemeColors, typography = themeTypography) {
    Scaffold(topAppBar = {
      AppTopBar(name = stringResource(id = R.string.app_name))
    }) {
      when (val data = observe(data = viewModel.dashboardItems)) {
        is Result.Loading -> {
          showLoading()
        }
        is Result.Success -> {
          showDashboard(data = data.data ?: emptyList())
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