package com.client.loginmultiuserapp.networking

import com.client.loginmultiuserapp.models.ResponseUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    // login service endpoint
    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseUser>
}