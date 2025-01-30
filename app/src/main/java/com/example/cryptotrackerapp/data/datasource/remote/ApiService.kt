package com.example.cryptotrackerapp.data.datasource.remote

import com.example.cryptotrackerapp.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("X-CMC_PRO_API_KEY:4c9189e4-0c29-4716-8cbe-f92aeee564fe")
    @GET("latest")
    suspend fun getCurrencies(): ApiResponse
}