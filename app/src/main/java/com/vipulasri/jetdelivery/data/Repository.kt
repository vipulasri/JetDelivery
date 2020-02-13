package com.vipulasri.jetdelivery.data

import com.vipulasri.jetdelivery.network.NetworkClient
import com.vipulasri.jetdelivery.network.model.Dashboard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

object Repository {

    private val apiService = NetworkClient.service

    suspend fun getDashboardData(): Result<List<Dashboard.Item>> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(apiService.getDashboard().data)
            } catch (exception: Exception) {
                Result.Failure(exception)
            }
        }
    }

}