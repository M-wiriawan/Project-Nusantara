package com.example.massive.retrofit


import com.example.massive.MainModel
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.PUT


interface ApiEndpoint {

    @POST("add events")
    fun addEvents(): Call<List<MainModel>>

    @PUT("update event")
    fun updateevent(): Call<UpdateEventViewModel>

}