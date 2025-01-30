package com.example.cryptotrackerapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotrackerapp.data.datasource.remote.ApiService
import com.example.cryptotrackerapp.data.model.Data
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataViewModel : ViewModel() {
    private val _dataList = MutableStateFlow<List<Data>>(emptyList())
    val dataList: StateFlow<List<Data>> get() = _dataList.asStateFlow()

    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    init {
        startFetchingData()
    }

    private fun startFetchingData() {
        viewModelScope.launch {
            flow {
                while (true) {
                    val response = fetchData()
                    Log.d("DataViewModel", "Emitting data: ${response.size} items")
                    emit(response)
                    delay(60000)
                }
            }.collectLatest { data ->
                _dataList.value = data
                Log.d("DataViewModel", "Updated dataList with ${data.size} items")
            }
        }
    }


    private suspend fun fetchData(): List<Data> {
        return try {
            val response = apiService.getCurrencies()
            Log.d("DataViewModel", "Fetched Data: ${response.data}")
            response.data
        } catch (e: Exception) {
            Log.e("DataViewModel", "Error fetching data: ${e.message}")
            emptyList()
        }
    }


}


