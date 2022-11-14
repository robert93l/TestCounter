package com.example.counters.data

import com.example.base_use_case.Either
import com.example.counters.domain.CountersRepository
import com.example.counters.domain.use_case.add_counter.AddCounterFailure
import com.example.counters.domain.use_case.add_counter.AddCounterResponse
import com.example.counters.domain.use_case.dec_counter.DecCounterFailure
import com.example.counters.domain.use_case.dec_counter.DecCounterResponse
import com.example.counters.domain.use_case.delete_counter.DeleteCounterFailure
import com.example.counters.domain.use_case.delete_counter.DeleteCounterResponse
import com.example.counters.domain.use_case.get_counters.GetCountersFailure
import com.example.counters.domain.use_case.get_counters.GetCountersParams
import com.example.counters.domain.use_case.get_counters.GetCountersResponse
import com.example.counters.domain.use_case.inc_counter.IncCounterFailure
import com.example.counters.domain.use_case.inc_counter.IncCounterResponse
import com.example.internetconnection.data.InternetConnectionRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class CountersRepositoryImpl : CountersRepository, KoinComponent {

    private val remoteDataSource: CountersRemoteDataSource by inject()

    private val internetConnectionRepository: InternetConnectionRepository by inject()

    override suspend fun addCounter(
        params: String
    ): Either<AddCounterFailure, AddCounterResponse> =
      /* if (internetConnectionRepository.isOnline)*/
            remoteDataSource.addCounter(params)
      /*  else Either.Left(AddCounterFailure.NetworkConnectionFailure)*/

    override suspend fun decCounter(
        params: String
    ): Either<DecCounterFailure, DecCounterResponse> =
        /*if (internetConnectionRepository.isOnline)*/
            remoteDataSource.decCounter(params)
     /*   else Either.Left(DecCounterFailure.NetworkConnectionFailure)*/

    override suspend fun deleteCounter(
        params: String
    ): Either<DeleteCounterFailure, DeleteCounterResponse> =
    /*    if (internetConnectionRepository.isOnline)*/
            remoteDataSource.deleteCounter(params)
      /*  else Either.Left(DeleteCounterFailure.NetworkConnectionFailure)*/

    override suspend fun getCounters(
        params: GetCountersParams
    ): Either<GetCountersFailure, GetCountersResponse> = remoteDataSource.getCounters(params)

    override suspend fun incCounter(
        params: String
    ): Either<IncCounterFailure, IncCounterResponse> =
        /*if (internetConnectionRepository.isOnline)*/
            remoteDataSource.incCounter(params)
       /* else Either.Left(IncCounterFailure.NetworkConnectionFailure)*/

}