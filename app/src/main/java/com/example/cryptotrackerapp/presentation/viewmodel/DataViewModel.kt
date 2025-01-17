package com.example.cryptotrackerapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotrackerapp.data.datasource.remote.ApiService
import com.example.cryptotrackerapp.data.model.Data
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataViewModel : ViewModel() {
    private val _dataList = MutableLiveData<List<Data>>()
    val dataList : LiveData<List<Data>> get() = _dataList

    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun fetchData(){
        viewModelScope.launch {
            try {
                val response = apiService.getCurrencies()
                _dataList.postValue(response.data)
                Log.d("Success Response", response.data.toString())

            }catch (e: Exception){
                Log.d("Error Message", e.message.toString())

            }
        }
    }

}