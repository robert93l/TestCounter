package com.example.counters.domain.use_case.dec_counter

import com.example.counters.domain.entity.Counter

data class DecCounterResponse(
    val counters: List<Counter>
)