package com.example.testcounter.di

import com.example.testcounter.di.presentation.homeModule
import org.koin.core.module.Module

fun getPresentationModules(): List<Module> = listOf(
    homeModule
)