package com.example.counters.data

import com.example.base_use_case.Either
import com.example.counters.domain.use_case.add_counter.AddCounterFailure
import com.example.counters.domain.use_case.add_counter.AddCounterResponse
import com.example.counters.domain.use_case.dec_counter.DecCounterFailure
import com.example.counters.domain.use_case.dec_counter.DecCounterResponse
import com.example.counters.domain.use_case.delete_counter.DeleteCounterFailure
import com.example.counters.domain.use_case.delete_counter.DeleteCounterResponse
import com.example.counters.domain.use_case.get_counters.GetCountersFailure
import com.example.counters.domain.use_case.get_counters.GetCountersParams
import com.example.counters.domain.use_case.get_counters.GetCountersResponse
import com.example.counters.domain.use_case.inc_counter.IncCounterFailure
import com.example.counters.domain.use_case.inc_counter.IncCounterResponse

internal interface CountersRemoteDataSource {

    suspend fun addCounter(
        title: String
    ): Either<AddCounterFailure, AddCounterResponse>

    suspend fun decCounter(
        id: String
    ): Either<DecCounterFailure, DecCounterResponse>

    suspend fun deleteCounter(
        id: String
    ): Either<DeleteCounterFailure, DeleteCounterResponse>

    suspend fun getCounters(
        params: GetCountersParams
    ): Either<GetCountersFailure, GetCountersResponse>

    suspend fun incCounter(
        id: String
    ): Either<IncCounterFailure, IncCounterResponse>

}