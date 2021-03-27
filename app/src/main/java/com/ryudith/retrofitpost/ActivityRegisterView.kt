package com.ryudith.retrofitpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryudith.retrofitpost.databinding.ActivityRegisterViewBinding

class ActivityRegisterView : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterViewBinding
    private lateinit var activityRef : ActivityRegisterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityRef = this
        binding = ActivityRegisterViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val about = intent.getStringExtra("about")

        binding.tvActivityRegisterViewName.text = name
        binding.tvActivityRegisterViewAge.text = age
        binding.tvActivityRegisterViewAbout.text = about
    }
}