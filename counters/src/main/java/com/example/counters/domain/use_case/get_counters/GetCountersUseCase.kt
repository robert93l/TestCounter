package com.example.counters.domain.use_case.get_counters

import com.example.base_use_case.Either
import com.example.base_use_case.UseCase

import com.example.counters.domain.CountersRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCountersUseCase:
    UseCase<GetCountersResponse, GetCountersParams, GetCountersFailure>(), KoinComponent {

    private val repository: CountersRepository by inject()

    override suspend fun run(
        params: GetCountersParams
    ): Either<GetCountersFailure, GetCountersResponse> =
        repository.getCounters(params)

}