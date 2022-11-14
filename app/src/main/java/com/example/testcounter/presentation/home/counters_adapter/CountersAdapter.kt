package com.example.testcounter.presentation.home.counters_adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.counters.domain.entity.Counter

class CountersAdapter(
    private val onCounterOnClickListener: (Counter) -> Unit
): ListAdapter<Counter, CountersViewHolder>(CountersDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountersViewHolder =
        CountersViewHolder.from(parent)

    override fun onBindViewHolder(holder: CountersViewHolder, position: Int) {
       val counter = getItem(position)
        holder.bind(counter = counter, onCounterClickListener = onCounterOnClickListener)
    }

    internal object CountersDiffUtil : DiffUtil.ItemCallback<Counter>() {

        override fun areItemsTheSame(
            oldItem: Counter,
            newItem: Counter
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: Counter,
            newItem: Counter
        ): Boolean = oldItem == newItem

    }

}