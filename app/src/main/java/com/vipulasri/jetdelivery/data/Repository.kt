package com.vipulasri.jetdelivery.data

import com.vipulasri.jetdelivery.network.Dashboard
import com.vipulasri.jetdelivery.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    private val apiService = NetworkClient.service

    suspend fun getDashboardData(): List<Dashboard.Item> {
        return withContext(Dispatchers.IO) {
            apiService.getData().data
        }
    }

}