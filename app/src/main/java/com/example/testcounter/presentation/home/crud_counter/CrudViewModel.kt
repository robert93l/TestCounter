package com.example.testcounter.presentation.home.crud_counter

import androidx.lifecycle.ViewModel
import com.example.counters.presentation.dec_counter.DecCounter
import com.example.counters.presentation.delete_counter.DeleteCounter
import com.example.counters.presentation.get_counters.GetCounters
import com.example.counters.presentation.inc_counter.IncCounter

class CrudViewModel(
    getCounters: GetCounters,
    deleteCounter: DeleteCounter,
    incCounter: IncCounter,
    decCounter: DecCounter
) : ViewModel(),
    GetCounters by getCounters,
    DeleteCounter by deleteCounter,
    IncCounter by incCounter,
    DecCounter by decCounter