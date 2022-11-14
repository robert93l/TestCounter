package com.example.testcounter.di

import com.example.http_client.httpClientModule
import com.example.internetconnection.internetConnectionModule
import org.koin.core.module.Module

fun getSharedModules(): List<Module> = listOf(
    internetConnectionModule,
    httpClientModule
)