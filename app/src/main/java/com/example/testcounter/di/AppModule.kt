package com.example.testcounter.di

import com.example.testcounter.CountersDevChallengeApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun CountersDevChallengeApp.initKoin() {
    val modules = getSharedModules() + getFeatureModules() + getPresentationModules()

    startKoin {
        androidContext(applicationContext)
        modules(modules)
    }

}