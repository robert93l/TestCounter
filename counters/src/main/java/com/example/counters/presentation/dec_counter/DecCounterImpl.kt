package com.example.counters.presentation.dec_counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.base_use_case.Status
import com.example.base_use_case.onLeft
import com.example.base_use_case.onRight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import com.example.counters.domain.use_case.dec_counter.DecCounterUseCase
import com.example.counters.presentation.dec_counter.DecCounter
import com.example.counters.presentation.dec_counter.DecCounterStatus
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DecCounterImpl: DecCounter, KoinComponent {

    private val decCounterUseCase: DecCounterUseCase by inject()

    override fun decCounterAsLiveData(
        id: String
    ): LiveData<DecCounterStatus> = flow<DecCounterStatus> {
        emit(Status.Loading())
        decCounterUseCase.run(id)
            .onLeft { emit(Status.Failed(it)) }
            .onRight { emit(Status.Done(it)) }
    }.asLiveData(Dispatchers.IO)
}