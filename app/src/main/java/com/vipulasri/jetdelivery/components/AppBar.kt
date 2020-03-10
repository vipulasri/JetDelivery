package com.vipulasri.jetdelivery.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Checkbox
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.unit.dp
import com.vipulasri.jetdelivery.R
import com.vipulasri.jetdelivery.ui.themeTypography

sealed class MenuAction(@StringRes val label: Int, @DrawableRes val icon: Int?) {
    object RandomDashboard : MenuAction(R.string.random_dashboard, null)
}

@Model
data class TopAppBarMenu(
    var showRandomDashboard: Boolean = false
)

@Composable
fun AppTopBar(name: String, menu: TopAppBarMenu) {
    TopAppBar<MenuAction>(
        color = Color.White,
        title = { Text(text = name) },
        actionData = listOf(MenuAction.RandomDashboard),
        action = { menuAction ->
            when (menuAction) {
                MenuAction.RandomDashboard -> {
                    randomDashboard(label = stringResource(id = menuAction.label), menu = menu)
                }
            }
        }
    )
}

@Composable
private fun randomDashboard(label: String, menu: TopAppBarMenu) {
    Row {
        Text(
            modifier = LayoutGravity.Center,
            text = label,
            style = themeTypography.caption)
        Spacer(modifier = LayoutWidth(5.dp))
        Checkbox(checked = menu.showRandomDashboard, onCheckedChange = {
            menu.showRandomDashboard = it
        })
    }
}