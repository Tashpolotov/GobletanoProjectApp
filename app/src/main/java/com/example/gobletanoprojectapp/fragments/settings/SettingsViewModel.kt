package com.example.gobletanoprojectapp.fragments.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _musicOn = MutableStateFlow<String>("on")
    val musicOn: StateFlow<String> = _musicOn

    fun loadState(setting: String) {
        viewModelScope.launch() {
            _musicOn.emit(setting)
        }
    }
}