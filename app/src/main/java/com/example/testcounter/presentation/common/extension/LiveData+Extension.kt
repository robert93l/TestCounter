package com.example.testcounter.presentation.common.extension

import androidx.lifecycle.LiveData

val LiveData<String>.valueOrEmpty
    get() = value?.trim().orEmpty()