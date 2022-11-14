package com.example.counters.domain.use_case.delete_counter

import com.example.base_use_case.Failure
import com.example.core.DefaultFailure
import com.example.core.NetworkFailure

import com.example.http_client.data.failureManage.HttpFailure
import com.example.http_client.data.failureManage.JsonDataFailure

sealed class DeleteCounterFailure: Failure() {

    object NetworkConnectionFailure: NetworkFailure, DeleteCounterFailure()

    data class JsonDeserializationFailure(
        override val message: String
    ) : JsonDataFailure, DeleteCounterFailure()

    data class ServerFailure(
        override val code: Int,
        override val message: String
    ) : HttpFailure, DeleteCounterFailure()

    data class UnknownFailure(
        override val message: String
    ) : DefaultFailure, DeleteCounterFailure()

}
