package com.ryudith.retrofitpost.util

import com.ryudith.retrofitpost.register.RegisterURL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitHelper {
    companion object {
        var BASEURL = "http://10.0.2.2/simple_php/"
        private var INSTANCE : Retrofit? = null

        fun createInstance(newInstance : Boolean = false, client : OkHttpClient? = null) : Retrofit {
            var newClient : OkHttpClient? = client
            if (newClient == null) {
                newClient = OkHttpClient.Builder().build()
            }

            if (newInstance) {
                return Retrofit.Builder()
                    .baseUrl(RetrofitHelper.BASEURL)
                    .client(newClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            if (INSTANCE != null) {
                return INSTANCE!!
            }

            INSTANCE = Retrofit.Builder()
                .baseUrl(RetrofitHelper.BASEURL)
                .client(newClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return INSTANCE!!
        }

        fun getRegisterRetrofit() : RegisterURL {
            return RetrofitHelper.createInstance().create(RegisterURL::class.java)
        }
    }
}