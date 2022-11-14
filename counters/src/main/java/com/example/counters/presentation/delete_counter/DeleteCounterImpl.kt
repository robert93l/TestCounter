package com.example.counters.presentation.delete_counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.base_use_case.Status
import com.example.base_use_case.onLeft
import com.example.base_use_case.onRight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import com.example.counters.domain.use_case.delete_counter.DeleteCounterUseCase
import com.example.counters.presentation.delete_counter.DeleteCounter
import com.example.counters.presentation.delete_counter.DeleteCounterStatus
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DeleteCounterImpl: DeleteCounter, KoinComponent {

    private val deleteCounterUseCase: DeleteCounterUseCase by inject()

    override fun deleteCounterAsLiveData(
        id: String
    ): LiveData<DeleteCounterStatus> = flow<DeleteCounterStatus> {
        emit(Status.Loading())
        deleteCounterUseCase.run(id)
            .onLeft { emit(Status.Failed(it)) }
            .onRight { emit(Status.Done(it)) }
    }.asLiveData(Dispatchers.IO)

}