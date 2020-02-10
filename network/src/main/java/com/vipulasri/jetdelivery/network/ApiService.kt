package com.vipulasri.jetdelivery.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("3f780a05ddc2416cc2d52a145a8c3ebe3f153cf8/data.json")
    suspend fun getData(): Dashboard

}

object NetworkClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)

    val service by lazy {
        retrofit.baseUrl("https://gist.githubusercontent.com/vipulasri/8bd2115e50fd73272ea8de08cd54b9d5/raw/")
            .build().create(ApiService::class.java)
    }

}