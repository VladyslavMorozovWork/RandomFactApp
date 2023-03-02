package com.example.randomfactapp.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel() {

    val errorFlow: StateFlow<Throwable?>
        get() = _errorFlow
    protected val _errorFlow: MutableStateFlow<Throwable?> = MutableStateFlow(null)

    fun clearErrors() {
        _errorFlow.value = null
    }
}