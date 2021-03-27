package com.ryudith.retrofitpost.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    val name : String,
    val age : String,
    val about : String,
    val greeting : String,

    @SerializedName("json_body")
    val jsonBody : Any
)
