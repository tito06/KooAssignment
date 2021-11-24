package com.example.kooassignment.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kooassignment.data.Data
import com.example.kooassignment.network.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

 var dataListResponse:List<Data> by mutableStateOf(listOf())
    var errorMessage : String by mutableStateOf("")

    fun getData(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val dataList = apiService.getData()
            }catch (e :Exception){
                errorMessage = e.message.toString()
            }

        }
    }
}