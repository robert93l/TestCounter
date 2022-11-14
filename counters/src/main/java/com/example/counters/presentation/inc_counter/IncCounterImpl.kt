package com.example.counters.presentation.inc_counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.base_use_case.Status
import com.example.base_use_case.onLeft
import com.example.base_use_case.onRight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

import com.example.counters.domain.use_case.inc_counter.IncCounterUseCase
import com.example.counters.presentation.inc_counter.IncCounter
import com.example.counters.presentation.inc_counter.IncCounterStatus
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IncCounterImpl: IncCounter, KoinComponent {

    private val incCounterUseCase: IncCounterUseCase by inject()

    override fun incCounterAsLiveData(
        id: String
    ): LiveData<IncCounterStatus> = flow<IncCounterStatus> {
        emit(Status.Loading())
        incCounterUseCase.run(id)
            .onLeft { emit(Status.Failed(it)) }
            .onRight { emit(Status.Done(it)) }
    }.asLiveData(Dispatchers.IO)

}