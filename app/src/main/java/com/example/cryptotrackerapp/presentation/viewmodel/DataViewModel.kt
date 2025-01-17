package com.example.cryptotrackerapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotrackerapp.data.datasource.remote.ApiService
import com.example.cryptotrackerapp.data.model.Currency
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CurrencyDataViewModel : ViewModel() {
    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList : LiveData<List<Currency>> get() = _currencyList

    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl("")//baseurl
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()

    fun fetchData(){
        viewModelScope.launch {
            try {
                val currencyList = apiService.getCurrencies()
                _currencyList.postValue(currencyList)
            }catch (e: Exception){
                Log.d("Error Message",e.message.toString())
            }
        }
    }
}