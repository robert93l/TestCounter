package com.example.testcounter.di

import com.example.counters.countersModule
import org.koin.core.module.Module

fun getFeatureModules(): List<Module> = listOf(
    countersModule
)