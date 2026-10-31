package com.raghav.greetingkmp.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raghav.greetingkmp.Greeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val greeting: Greeting
) : ViewModel() {
    val greetingList: StateFlow<List<String>>
        field = MutableStateFlow<List<String>>(listOf())

    init {
        viewModelScope.launch {
            greeting.greet().collect { phrase ->
                greetingList.update { list -> list + phrase }
            }
        }
    }
}
