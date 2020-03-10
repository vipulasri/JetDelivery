package com.vipulasri.jetdelivery.network

import com.vipulasri.jetdelivery.network.model.Dashboard
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("data.json")
    suspend fun getDashboard(): Dashboard

    @GET("data-random.json")
    suspend fun getRandomDashboard(): Dashboard

}

object NetworkClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)

    val service: ApiService by lazy {
        retrofit.baseUrl("https://gist.githubusercontent.com/vipulasri/8bd2115e50fd73272ea8de08cd54b9d5/raw/")
            .build().create(ApiService::class.java)
    }

}