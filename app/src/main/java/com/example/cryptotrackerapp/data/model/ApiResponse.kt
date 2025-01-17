package com.example.cryptotrackerapp.data.model


data class ApiResponse(
    val data : List<Data>
)

data class Data(
    val id: Int,
    val name: String,
    val symbol: String,
    val quote: Quote
)

data class Quote(
    val USD: USD
)

data class USD(
    val price: Double,
    val percent_change_24h: Double
)