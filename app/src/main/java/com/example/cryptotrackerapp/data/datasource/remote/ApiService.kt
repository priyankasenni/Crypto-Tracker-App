package com.example.cryptotrackerapp.data.datasource.remote

import com.example.cryptotrackerapp.data.model.Data
import retrofit2.http.GET

interface ApiService {
    @GET("") //Endpoint
    suspend fun getData(): List<Data>
}