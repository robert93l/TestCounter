package com.example.counters.presentation.delete_counter

import androidx.lifecycle.LiveData
import com.example.base_use_case.Status
import com.example.counters.domain.use_case.delete_counter.DeleteCounterFailure
import com.example.counters.domain.use_case.delete_counter.DeleteCounterResponse

typealias DeleteCounterStatus = Status<DeleteCounterFailure, DeleteCounterResponse>

interface DeleteCounter {

    fun deleteCounterAsLiveData(
        id: String
    ): LiveData<DeleteCounterStatus>

}