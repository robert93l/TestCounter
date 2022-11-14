package com.example.counters.domain.use_case.inc_counter

import com.example.base_use_case.Failure
import com.example.core.DefaultFailure
import com.example.core.NetworkFailure
import com.example.http_client.data.failureManage.HttpFailure
import com.example.http_client.data.failureManage.JsonDataFailure

sealed class IncCounterFailure: Failure() {

    object NetworkConnectionFailure: NetworkFailure, IncCounterFailure()

    data class JsonDeserializationFailure(
        override val message: String
    ) : JsonDataFailure, IncCounterFailure()

    data class ServerFailure(
        override val code: Int,
        override val message: String
    ) : HttpFailure, IncCounterFailure()

    data class UnknownFailure(
        override val message: String
    ) : DefaultFailure, IncCounterFailure()

}
