package com.ryudith.retrofitpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.ryudith.retrofitpost.databinding.ActivityMainBinding
import com.ryudith.retrofitpost.register.Register
import com.ryudith.retrofitpost.util.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var activityRef : MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityRef = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActivityMainRegister.setOnClickListener {
            val name = binding.etActivityMainName.text.toString()
            val age = binding.etActivityMainAge.text.toString().toInt()
            val about = binding.etActivityMainAbout.text.toString()

            saveRegisterData(name, age, about)
        }
    }

    private fun saveRegisterData(name : String, age : Int, about : String) {
        val register = RetrofitHelper.getRegisterRetrofit()

        lifecycleScope.launch(Dispatchers.IO) {
//            val resp = register.register(name, age, about)
            val resp = register.registerJson(Register(name, age, about))

            val intent = Intent(activityRef, ActivityRegisterView::class.java)
            intent.putExtra("name", resp.name)
            intent.putExtra("age", resp.age)
            intent.putExtra("about", resp.about)
            startActivity(intent)
        }
    }
}