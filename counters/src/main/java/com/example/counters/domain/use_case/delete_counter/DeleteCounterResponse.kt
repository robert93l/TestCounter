package com.example.counters.domain.use_case.delete_counter

import com.example.counters.domain.entity.Counter

data class DeleteCounterResponse(
    val counters: List<Counter>
)