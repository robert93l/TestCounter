package com.example.http_client

import com.example.http_client.data.RetrofitBuilder
import org.koin.dsl.module
import retrofit2.Retrofit

val httpClientModule = module {

    single<Retrofit> {
        RetrofitBuilder().build()
    }

}