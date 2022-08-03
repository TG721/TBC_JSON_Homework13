package com.example.tbc_android_homework_13.api

import com.example.tbc_android_homework_13.model.Post
import retrofit2.http.GET

interface MyApi {

    @GET("v3/3588163c-a9c8-488c-af9a-534b392e7128")
    suspend fun getPost(): retrofit2.Response<Post>
}