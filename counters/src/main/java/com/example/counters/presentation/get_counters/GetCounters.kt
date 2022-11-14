package com.example.counters.presentation.get_counters

import androidx.lifecycle.LiveData
import com.example.base_use_case.Either
import com.example.base_use_case.Status
import com.example.counters.domain.use_case.get_counters.GetCountersFailure
import com.example.counters.domain.use_case.get_counters.GetCountersParams
import com.example.counters.domain.use_case.get_counters.GetCountersResponse

typealias GetCountersStatus = Status<GetCountersFailure, GetCountersResponse>

interface GetCounters {

    var getCountersResponse: GetCountersResponse

    var getCountersFailure: GetCountersFailure?

    fun getCountersAsLiveData(
        params: GetCountersParams
    ): LiveData<GetCountersStatus>

    suspend fun getCountersAsEither(
        params: GetCountersParams
    ): Either<GetCountersFailure, GetCountersResponse>

}