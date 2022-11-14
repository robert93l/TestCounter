package com.example.testcounter.presentation.home.counters_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testcounter.databinding.ItemCounterBinding
import com.example.counters.domain.entity.Counter


class CountersViewHolder(
    private val binding: ItemCounterBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(counter: Counter, onCounterClickListener: (Counter) -> Unit) {
        binding.apply {
            itemCounterTvId.text = counter.id
            itemCounterTvTitle.text = counter.title
            itemCounterTvCount.text = counter.count.toString()
            root.setOnClickListener { onCounterClickListener(counter) }
        }
    }

    companion object {
        fun from(parent: ViewGroup): CountersViewHolder {
            val binding = ItemCounterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return CountersViewHolder(binding)
        }
    }

}