package com.vipulasri.jetdelivery.data

import com.vipulasri.jetdelivery.network.NetworkClient
import com.vipulasri.jetdelivery.network.model.Dashboard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    private val apiService = NetworkClient.service

    suspend fun getDashboardData(): List<Dashboard.Item> {
        return withContext(Dispatchers.IO) {
            apiService.getDashboard().data
        }
    }

}