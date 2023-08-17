package com.example.gobletanoprojectapp.fragments.level

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor() : ViewModel() {
    private val _level = MutableStateFlow<Int>(1)
    val level: StateFlow<Int> = _level

    fun loadState(level: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _level.emit(level)
        }
    }
}