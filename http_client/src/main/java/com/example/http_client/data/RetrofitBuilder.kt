package com.example.http_client.data


import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


class RetrofitBuilder() {



    @OptIn(ExperimentalSerializationApi::class)
    fun build(): Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.111:3100")  //http://10.0.2.2:3100
        .client(provideOkHttpClient())
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.asConverterFactory(Constants.CONTENT_TYPE.toMediaTypeOrNull()!!)
        ).build()

    private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .readTimeout(2, TimeUnit.SECONDS)
            .build()

    private object Constants {
        const val CONTENT_TYPE = "application/json"
    }

}