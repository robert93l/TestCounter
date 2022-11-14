package com.example.internetconnection.data

import androidx.lifecycle.LiveData

interface InternetConnectionRepository {

    val isOnline: Boolean

    val isOnlineLiveData: LiveData<Boolean>

    suspend fun fetch()

}