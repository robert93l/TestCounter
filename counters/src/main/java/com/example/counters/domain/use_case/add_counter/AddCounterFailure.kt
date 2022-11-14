package com.example.counters.domain.use_case.add_counter

import com.example.base_use_case.Failure
import com.example.core.DefaultFailure
import com.example.core.NetworkFailure
import com.example.http_client.data.failureManage.HttpFailure
import com.example.http_client.data.failureManage.JsonDataFailure

sealed class AddCounterFailure: Failure() {

 object NetworkConnectionFailure: NetworkFailure, AddCounterFailure()

 data class JsonDeserializationFailure(
  override val message: String
 ) : JsonDataFailure, AddCounterFailure()

 data class ServerFailure(
  override val code: Int,
  override val message: String
 ) : HttpFailure, AddCounterFailure()

 data class UnknownFailure(
  override val message: String
 ) : DefaultFailure, AddCounterFailure()

}