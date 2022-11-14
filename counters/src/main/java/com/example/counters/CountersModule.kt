package com.example.counters

import com.example.counters.data.CountersRemoteDataSource
import com.example.counters.data.CountersRepositoryImpl
import com.example.counters.data.remote.CountersRemoteDataSourceImpl
import com.example.counters.data.remote.service.CountersApiService
import com.example.counters.domain.CountersRepository
import com.example.counters.domain.use_case.add_counter.AddCounterUseCase
import com.example.counters.domain.use_case.dec_counter.DecCounterUseCase
import com.example.counters.domain.use_case.delete_counter.DeleteCounterUseCase
import com.example.counters.domain.use_case.get_counters.GetCountersUseCase
import com.example.counters.domain.use_case.inc_counter.IncCounterUseCase
import com.example.counters.presentation.add_counter.AddCounter
import com.example.counters.presentation.add_counter.AddCounterImpl
import com.example.counters.presentation.dec_counter.DecCounter
import com.example.counters.presentation.dec_counter.DecCounterImpl
import com.example.counters.presentation.delete_counter.DeleteCounter
import com.example.counters.presentation.delete_counter.DeleteCounterImpl
import com.example.counters.presentation.get_counters.GetCounters
import com.example.counters.presentation.get_counters.GetCountersImpl
import com.example.counters.presentation.inc_counter.IncCounter
import com.example.counters.presentation.inc_counter.IncCounterImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val countersModule = module {

    /** PRESENTATION **/
    single<AddCounter> { AddCounterImpl() }
    single<DecCounter> { DecCounterImpl() }
    single<DeleteCounter> { DeleteCounterImpl() }
    single<GetCounters> { GetCountersImpl() }
    single<IncCounter> { IncCounterImpl() }

    /** USE CASE **/
    factory { AddCounterUseCase() }
    factory { DecCounterUseCase() }
    factory { DeleteCounterUseCase() }
    factory { GetCountersUseCase() }
    factory { IncCounterUseCase() }

    /** REPOSITORY **/
    single<CountersRepository> { CountersRepositoryImpl() }

    /** DATA SOURCE **/
    single<CountersRemoteDataSource> { CountersRemoteDataSourceImpl() }

    /** API SERVICE **/
    single { get<Retrofit>().create(CountersApiService::class.java) }

}