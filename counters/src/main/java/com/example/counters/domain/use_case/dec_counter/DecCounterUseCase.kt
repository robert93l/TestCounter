package com.example.counters.domain.use_case.dec_counter

import com.example.base_use_case.Either
import com.example.base_use_case.UseCase

import com.example.counters.domain.CountersRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DecCounterUseCase: UseCase<DecCounterResponse, String, DecCounterFailure>(), KoinComponent {

    private val repository: CountersRepository by inject()

    override suspend fun run(
        params: String
    ): Either<DecCounterFailure, DecCounterResponse> =
        repository.decCounter(params)

}