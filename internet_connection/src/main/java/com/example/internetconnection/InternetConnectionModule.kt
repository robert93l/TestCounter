package com.example.internetconnection

import com.example.internetconnection.data.InternetConnectionRepository
import com.example.internetconnection.data.InternetConnectionRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val internetConnectionModule: Module = module {

    single<InternetConnectionRepository>(createdAtStart = true) {
        InternetConnectionRepositoryImpl()
    }

}