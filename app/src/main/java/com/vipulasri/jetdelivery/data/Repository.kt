package com.vipulasri.jetdelivery.data

import com.vipulasri.jetdelivery.network.NetworkClient
import com.vipulasri.jetdelivery.network.model.Dashboard
import java.lang.Exception
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Repository {

    private val apiService = NetworkClient.service

    suspend fun getDashboardData(isRandomRequired: Boolean = false): Result<List<Dashboard.Item>> {
        return withContext(Dispatchers.IO) {
            try {
                if(isRandomRequired) {
                    Result.Success(apiService.getRandomDashboard().data)
                } else {
                    Result.Success(apiService.getDashboard().data)
                }
            } catch (exception: Exception) {
                Result.Failure(exception)
            }
        }
    }
}
