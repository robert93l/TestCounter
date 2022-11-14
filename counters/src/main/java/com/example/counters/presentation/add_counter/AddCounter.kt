package com.example.counters.presentation.add_counter

import androidx.lifecycle.LiveData
import com.example.base_use_case.Status

import com.example.counters.domain.use_case.add_counter.AddCounterFailure
import com.example.counters.domain.use_case.add_counter.AddCounterResponse

typealias AddCounterStatus = Status<AddCounterFailure, AddCounterResponse>

interface AddCounter {

    fun addCounterAsLiveData(
        title: String
    ): LiveData<AddCounterStatus>

}