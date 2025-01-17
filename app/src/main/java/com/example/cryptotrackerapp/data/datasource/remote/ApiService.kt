package com.example.cryptotrackerapp.data.datasource.remote

import com.example.cryptotrackerapp.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("X-CMC_PRO_API_KEY:30305ead-5ba4-4215-8fcb-29d574e327a2")
    @GET("latest")
    suspend fun getCurrencies(): ApiResponse
}