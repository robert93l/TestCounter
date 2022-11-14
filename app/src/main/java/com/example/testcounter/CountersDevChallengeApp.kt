package com.example.testcounter

import android.app.Application
import com.example.testcounter.di.initKoin

class CountersDevChallengeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

}