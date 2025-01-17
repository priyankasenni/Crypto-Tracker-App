package com.example.cryptotrackerapp.data.model


data class ApiResponse(
    val data : List<Data>
)

data class Data(
    val name: String
)