package com.example.counters.presentation.inc_counter

import androidx.lifecycle.LiveData
import com.example.base_use_case.Status
import com.example.counters.domain.use_case.inc_counter.IncCounterFailure
import com.example.counters.domain.use_case.inc_counter.IncCounterResponse

typealias IncCounterStatus = Status<IncCounterFailure, IncCounterResponse>

interface IncCounter {

    fun incCounterAsLiveData(
        id: String
    ): LiveData<IncCounterStatus>

}