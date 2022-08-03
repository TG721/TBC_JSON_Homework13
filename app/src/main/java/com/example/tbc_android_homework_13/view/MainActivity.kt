package com.example.tbc_android_homework_13.view

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tbc_android_homework_13.MainViewModel
import com.example.tbc_android_homework_13.MainViewModelFactory
import com.example.tbc_android_homework_13.R
import com.example.tbc_android_homework_13.databinding.ActivityMainBinding
import com.example.tbc_android_homework_13.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPost()
        val finalText = binding.finalText
        viewModel.myResponse.observe(this, Observer {
            if (it.isSuccessful) {
                finalText.text = it.body()?.toString()
                finalText.setTextColor(ContextCompat.getColor(this, R.color.white))
            } else {
                d("Response", it.errorBody().toString())
                finalText.text = it.code().toString()
                finalText.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        })
    }
}