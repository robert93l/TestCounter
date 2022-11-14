package com.example.testcounter.presentation.home.crud_counter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.base_use_case.Status
import com.example.testcounter.databinding.CrudFragmentBinding

import com.example.counters.domain.entity.Counter
import com.example.counters.presentation.dec_counter.DecCounterStatus
import com.example.counters.presentation.delete_counter.DeleteCounterStatus
import com.example.counters.presentation.inc_counter.IncCounterStatus

import com.example.testcounter.presentation.common.enums.CounterOptions
import com.example.testcounter.presentation.common.extension.android.showMaterialDialog
import com.example.testcounter.presentation.common.extension.android.showSnackbar
import com.example.testcounter.presentation.home.counters_adapter.CountersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class CrudFragment : Fragment() {

    private val binding: CrudFragmentBinding by lazy {
        CrudFragmentBinding.inflate(layoutInflater)
    }

    private val args: CrudFragmentArgs by navArgs()

    private val viewModel: CrudViewModel by viewModel()

    private val countersAdapter: CountersAdapter by lazy {
        CountersAdapter(onCounterOnClickListener = onCounterRowClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()

    }

    private fun setUpRecycler() {
        val counters = viewModel.getCountersResponse.counters
        binding.crudFragmentRvCounters.adapter = countersAdapter
        countersAdapter.submitList(counters)
        binding.crudFragmentRvCounters.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

    }

    private val onCounterRowClick: (Counter) -> Unit = {
        showMaterialDialog(
            title = "Change confirmation",
            message = "This element will be modified: $it",
            positiveText = "Are you sure?",
            negativeText = "Cancel",
            action = { _, _ ->
                when(CounterOptions.toCounterOptions(args.option)) {
                    CounterOptions.DELETE -> executeDeleteCounter(counter = it)
                    CounterOptions.INCREASE -> executeIncCounter(counter = it)
                    CounterOptions.DECREASE -> executeDecCounter(counter = it)
                    else -> Timber.e("Error counter options")
                }
            }
        )
    }

    private fun executeDeleteCounter(counter: Counter) {
        viewModel.deleteCounterAsLiveData(id = counter.id)
            .observe(viewLifecycleOwner, deleteCounter())
    }

    private fun deleteCounter() = Observer<DeleteCounterStatus> {
        when (it) {
            is Status.Loading -> {/* PASS */}
            is Status.Failed -> showSnackbar(it.failure.toString())
            is Status.Done -> findNavController().popBackStack()
        }
    }

    private fun executeIncCounter(counter: Counter) {
        viewModel.incCounterAsLiveData(id = counter.id)
            .observe(viewLifecycleOwner, incCounter())
    }

    private fun incCounter() = Observer<IncCounterStatus> {
        when (it) {
            is Status.Loading -> {/* PASS */}
            is Status.Failed -> showSnackbar(it.failure.toString())
            is Status.Done -> findNavController().popBackStack()
        }
    }

    private fun executeDecCounter(counter: Counter) {
        viewModel.decCounterAsLiveData(id = counter.id)
            .observe(viewLifecycleOwner, decCounter())
    }

    private fun decCounter() = Observer<DecCounterStatus> {
        when (it) {
            is Status.Loading -> {/* PASS */}
            is Status.Failed -> showSnackbar(it.failure.toString())
            is Status.Done -> findNavController().popBackStack()
        }
    }

}