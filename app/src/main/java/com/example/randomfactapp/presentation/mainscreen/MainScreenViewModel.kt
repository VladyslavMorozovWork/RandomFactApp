package com.example.randomfactapp.presentation.mainscreen

import androidx.lifecycle.viewModelScope
import com.example.randomfactapp.common.BaseViewModel
import com.example.randomfactapp.domain.models.UiFactModel
import com.example.randomfactapp.domain.usecases.GetInitialListUseCase
import com.example.randomfactapp.domain.usecases.GetRandomFactUseCase
import com.example.randomfactapp.domain.usecases.RandomFactApiResponse
import com.example.randomfactapp.domain.usecases.TypeOfCall
import com.example.randomfactapp.utils.CantBeEmpty
import com.example.randomfactapp.utils.DataNotLoadedException
import com.example.randomfactapp.utils.NetworkErrorException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getInitialListUseCase: GetInitialListUseCase,
    private val getRandomFactUseCase: GetRandomFactUseCase
) : BaseViewModel() {
    val listOfFactsFlow: StateFlow<List<UiFactModel>>
        get() = _listOfFactsFlow
    private var _listOfFactsFlow = MutableStateFlow(emptyList<UiFactModel>())

    init {
        initialRequest()
    }

    private fun initialRequest() {
        viewModelScope.launch {
            val listOfFacts = getInitialListUseCase()
            if (listOfFacts.isNotEmpty()) {
                _listOfFactsFlow.value = listOfFacts
            }
        }
    }

    fun getFactByNumber(number: String) {
        if (number.isNotBlank()) {
            viewModelScope.launch {
                val result = getRandomFactUseCase(TypeOfCall.CallByNumber(number.toLong()))
                when (result) {
                    RandomFactApiResponse.Error -> {
                        _errorFlow.value = DataNotLoadedException()
                    }
                    RandomFactApiResponse.NetworkError -> {
                        _errorFlow.value = NetworkErrorException()
                    }
                    is RandomFactApiResponse.Success -> {
                        _listOfFactsFlow.value = result.factList
                    }
                }
            }
        } else {
            _errorFlow.value = CantBeEmpty()
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            val result = getRandomFactUseCase(TypeOfCall.RandomNumberCall)
            when (result) {
                RandomFactApiResponse.Error -> {
                    _errorFlow.value = DataNotLoadedException()
                }
                RandomFactApiResponse.NetworkError -> {
                    _errorFlow.value = NetworkErrorException()
                }
                is RandomFactApiResponse.Success -> {
                    _listOfFactsFlow.value = result.factList
                }
            }
        }
    }
}