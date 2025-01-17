package com.example.cryptotrackerapp.data.datasource.remote

import com.example.cryptotrackerapp.data.model.Currency
import retrofit2.http.GET

interface ApiService {
    @GET("") //Endpoint
    suspend fun getCurrencies(): List<Currency>
}