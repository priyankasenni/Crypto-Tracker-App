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
import retrofit2.create

class DataViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Data>>()
    val data : LiveData<List<Data>> get() = _data

    private val apiService: ApiService = Retrofit.Builder()
        .baseUrl("")//baseurl
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()

    fun fetchData(){
        viewModelScope.launch {
            try {

            }catch (e: Exception){
                Log.d("Error Message",e.message.toString())
            }
        }
    }
}