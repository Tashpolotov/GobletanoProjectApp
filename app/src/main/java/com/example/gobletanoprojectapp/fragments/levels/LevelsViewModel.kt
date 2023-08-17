package com.example.gobletanoprojectapp.fragments.levels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelsViewModel @Inject constructor() : ViewModel() {
    private val _levels = MutableStateFlow<Int>(1)
    val level: StateFlow<Int> = _levels

    fun loadState(level: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _levels.emit(level)
        }
    }
}