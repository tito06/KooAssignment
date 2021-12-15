package com.example.kooassignment.network

import com.example.kooassignment.data.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("public/v1/posts")
    suspend fun getData() : List<Data>


    companion object{

        var apiService: ApiService? = null
        fun getInstance(): ApiService{
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://gorest.co.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }

    }
}