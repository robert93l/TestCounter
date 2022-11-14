package com.example.counters.presentation.dec_counter

import androidx.lifecycle.LiveData
import com.example.base_use_case.Status
import com.example.counters.domain.use_case.dec_counter.DecCounterFailure
import com.example.counters.domain.use_case.dec_counter.DecCounterResponse

typealias DecCounterStatus = Status<DecCounterFailure, DecCounterResponse>

interface DecCounter {

    fun decCounterAsLiveData(
        id: String
    ): LiveData<DecCounterStatus>

}