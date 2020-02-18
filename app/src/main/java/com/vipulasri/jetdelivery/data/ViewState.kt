package com.vipulasri.jetdelivery.data

import androidx.compose.Composable
import androidx.compose.onCommit
import androidx.compose.remember
import androidx.compose.state
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.vipulasri.jetdelivery.network.model.Dashboard

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    class Success<T>(val data: T?) : Result<T>()
    class Failure(val error: Throwable) : Result<Nothing>()
}

sealed class DashboardViewState {
    object Loading : DashboardViewState()
    class Success(val data: List<Dashboard.Item>) : DashboardViewState()
    class Failure(val error: Throwable) : DashboardViewState()
}

/**
 * Based on https://medium.com/swlh/android-mvi-with-jetpack-compose-b0890f5156ac
 * Adapted for 0.1.0-dev04
 */
@Composable
fun <T> observe(data: LiveData<T>): T? {
    var result by state { data.value }
    val observer = remember { Observer<T> { result = it } }

    onCommit(data) {
        data.observeForever(observer)
        onDispose { data.removeObserver(observer) }
    }

    return result
}
