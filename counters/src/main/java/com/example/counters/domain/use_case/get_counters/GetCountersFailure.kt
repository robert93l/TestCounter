package com.example.counters.domain.use_case.get_counters

import com.example.base_use_case.Failure
import com.example.core.DefaultFailure
import com.example.core.NetworkFailure
import com.example.http_client.data.failureManage.HttpFailure
import com.example.http_client.data.failureManage.JsonDataFailure

sealed class GetCountersFailure: Failure() {

    object NetworkConnectionFailure: NetworkFailure, GetCountersFailure()

    data class JsonDeserializationFailure(
        override val message: String
    ) : JsonDataFailure, GetCountersFailure()

    data class ServerFailure(
        override val code: Int,
        override val message: String
    ) : HttpFailure, GetCountersFailure()

    data class UnknownFailure(
        override val message: String
    ) : DefaultFailure, GetCountersFailure()

}
