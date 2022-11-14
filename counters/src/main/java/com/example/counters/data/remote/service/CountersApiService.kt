package com.example.counters.data.remote.service

import com.example.counters.data.remote.model.dto.CounterDto
import com.example.counters.data.remote.service.request.AddCounterRequest
import com.example.counters.data.remote.service.request.DecCounterRequest
import com.example.counters.data.remote.service.request.DeleteCounterRequest
import com.example.counters.data.remote.service.request.IncCounterRequest
import retrofit2.Response
import retrofit2.http.*

internal interface CountersApiService {


    @GET(URL.GET_COUNTERS)
    suspend fun getCounters(): Response<List<CounterDto>>


    @POST(URL.ADD_COUNTER)
    suspend fun addCounter(
        @Body request: AddCounterRequest
    ): Response<List<CounterDto>>

    @POST(URL.INC_COUNTER)
    suspend fun incCounter(
        @Body request: IncCounterRequest
    ): Response<List<CounterDto>>

    @POST(URL.DEC_COUNTER)
    suspend fun decCounter(
        @Body request: DecCounterRequest
    ): Response<List<CounterDto>>

    @HTTP(method = "DELETE", path = URL.DELETE_COUNTER, hasBody = true)
    suspend fun deleteCounter(
        @Body request: DeleteCounterRequest
    ): Response<List<CounterDto>>

    private object URL {

        const val GET_COUNTERS: String = "/api/v1/counters"

        const val ADD_COUNTER: String = "/api/v1/counter"

        const val INC_COUNTER: String = "/api/v1/counter/inc"

        const val DEC_COUNTER: String = "/api/v1/counter/dec"

        const val DELETE_COUNTER: String = "/api/v1/counter"

    }

}