package com.example.testcounter.presentation.home

import androidx.lifecycle.ViewModel
import com.example.counters.presentation.get_counters.GetCounters

class HomeViewModel(
    getCounters: GetCounters
) : ViewModel(),
    GetCounters by getCounters