package com.example.counters.domain.use_case.inc_counter

import com.example.counters.domain.entity.Counter

data class IncCounterResponse(
    val counters: List<Counter>
)