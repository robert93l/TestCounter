package com.example.counters.domain.use_case.dec_counter

import com.example.base_use_case.Failure
import com.example.core.DefaultFailure
import com.example.core.NetworkFailure

import com.example.http_client.data.failureManage.HttpFailure
import com.example.http_client.data.failureManage.JsonDataFailure

sealed class DecCounterFailure: Failure() {

    object NetworkConnectionFailure: NetworkFailure, DecCounterFailure()

    data class JsonDeserializationFailure(
        override val message: String
    ) : JsonDataFailure, DecCounterFailure()

    data class ServerFailure(
        override val code: Int,
        override val message: String
    ) : HttpFailure, DecCounterFailure()

    data class UnknownFailure(
        override val message: String
    ) : DefaultFailure, DecCounterFailure()

}
