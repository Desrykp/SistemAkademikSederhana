package com.client.loginmultiuserapp.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        const val BASE_URL = "http://192.168.43.247/backend-login/"

        fun getClientAPI() : ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }

        // Interceptor OKHTTP3
        private fun okHttpInterceptor(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }

}