package com.example.testcounter.di.presentation

import com.example.testcounter.presentation.home.HomeViewModel
import com.example.testcounter.presentation.home.add_counter.AddCounterViewModel
import com.example.testcounter.presentation.home.crud_counter.CrudViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel {
        HomeViewModel(getCounters = get())
    }

    viewModel {
        CrudViewModel(
            getCounters = get(),
            deleteCounter = get(),
            incCounter = get(),
            decCounter = get()
        )
    }

    viewModel {
        AddCounterViewModel(addCounter = get())
    }

}