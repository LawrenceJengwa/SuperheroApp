package com.lawrence.superheroapp.rest

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitClient {
    private const val BASE_URL = "https://superheroapi.com//"
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttp = OkHttpClient.Builder()
            .addInterceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                        .addHeader("Accept-Language", Locale.getDefault().language)
                        .addHeader("access-token", "105581651029925")
                        .build()
                chain.proceed(request)
            }
            .addInterceptor(logger)
    private val builder = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
    private val retrofit = builder.build()
    @JvmStatic
    fun <S> buildService(serviceType: Class<S>?): S {
        return retrofit.create(serviceType)
    }
}