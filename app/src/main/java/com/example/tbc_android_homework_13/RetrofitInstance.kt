package com.example.tbc_android_homework_13

import com.example.tbc_android_homework_13.api.MyApi
import com.example.tbc_android_homework_13.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: MyApi by lazy {
        retrofit.create(MyApi::class.java)
    }
}