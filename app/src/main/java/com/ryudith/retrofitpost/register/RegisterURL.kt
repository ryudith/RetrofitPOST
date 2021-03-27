package com.ryudith.retrofitpost.register

import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterURL {
    @FormUrlEncoded
    @POST("method_post.php")
    suspend fun register(
        @Field("name") name : String,
        @Field("age") age : Int,
        @Field("about") about : String
    ) : RegisterResponse;

    @POST("method_post.php")
    suspend fun registerJson(
        @Body regData : Register
    ) : RegisterResponse;
}