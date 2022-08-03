package com.example.tbc_android_homework_13.repository

import com.example.tbc_android_homework_13.RetrofitInstance
import com.example.tbc_android_homework_13.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}