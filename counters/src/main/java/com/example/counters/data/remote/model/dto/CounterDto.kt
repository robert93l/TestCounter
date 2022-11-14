package com.example.counters.data.remote.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.example.counters.domain.entity.Counter

@Serializable
internal data class CounterDto(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("count") val count: Int
) {

    fun toCounter() = Counter(
        id = id,
        title = title,
        count = count
    )

}