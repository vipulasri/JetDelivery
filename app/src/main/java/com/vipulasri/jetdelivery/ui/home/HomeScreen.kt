package com.vipulasri.jetdelivery.ui.home

import androidx.compose.Composable
import androidx.ui.layout.Column
import androidx.ui.res.stringResource
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.ui.AppTopBar

@Composable
fun HomeScreen() {
    Column {
        AppTopBar(stringResource(id = R.string.app_name))
    }
}