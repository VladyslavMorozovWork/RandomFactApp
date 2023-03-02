package com.example.randomfactapp.presentation.mainscreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.randomfactapp.R
import com.example.randomfactapp.common.BaseFragment
import com.example.randomfactapp.databinding.FragmentMainScreenBinding
import com.example.randomfactapp.domain.models.UiFactModel
import com.example.randomfactapp.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainScreenFragment : BaseFragment(R.layout.fragment_main_screen) {
    private val viewModel by viewModels<MainScreenViewModel>()
    private val binding by viewBinding(FragmentMainScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FactListAdapter(FactItemInteractorImpl())
        with(binding) {
            factsList.adapter = adapter
            getFactByNumberBtn.onClick {
                viewModel.getFactByNumber(inputNumber.text.toString())
            }
            getRandomFactBtn.onClick {
                viewModel.getRandomFact()
            }
        }

        viewModel.listOfFactsFlow.onEach { list ->
            if (list.isEmpty()) return@onEach
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.errorFlow.onEach { error ->
            when (error) {
                is NetworkErrorException -> {
                    Toast.makeText(requireContext(), "Network Error", Toast.LENGTH_LONG).show()
                }
                is DataNotLoadedException -> {
                    Toast.makeText(requireContext(), "Data Loading Error", Toast.LENGTH_LONG).show()
                }
                is CantBeEmpty -> {
                    binding.searchFactLayout.validationFieldErrorWith(
                        requireContext(),
                        "Field number is empty"
                    )
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private inner class FactItemInteractorImpl : FactListHolder.Interactor {
        override fun onFactClicked(item: UiFactModel) {
            findNavController().navigate(
                MainScreenFragmentDirections.actionMainScreenFragmentToInfoFragment(
                    item
                )
            )
        }
    }
}