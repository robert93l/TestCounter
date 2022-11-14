package com.example.testcounter.presentation.home.add_counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.counters.presentation.add_counter.AddCounter
import com.example.testcounter.presentation.common.extension.valueOrEmpty

class AddCounterViewModel(
    addCounter: AddCounter
) : ViewModel(),
    AddCounter by addCounter {

    val titleLiveData: MutableLiveData<String> = MutableLiveData()
    val title: String get() = titleLiveData.valueOrEmpty

    fun isNotBlankTitle(): Boolean = title.isNotBlank()

}