package com.generic.wallet.after_dg.dataclasses.mvvm

import com.generic.wallet.after_dg.dataclasses.RegisterData
import com.generic.wallet.after_dg.dataclasses.User
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {


    @POST("posts")
    suspend fun postUser(@Body user: RegisterData) : Response<RegisterData>

}


object ApiImplementation {
    val apiInterface: ApiInterface by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create())).build()
            .create(ApiInterface::class.java)
    }

}