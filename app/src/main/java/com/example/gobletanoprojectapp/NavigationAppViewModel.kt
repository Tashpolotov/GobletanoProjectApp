package com.example.gobletanoprojectapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gobletanoprojectapp.util.MenuScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationAppViewModel @Inject constructor() : ViewModel(){
    private val _menuScreens = MutableStateFlow<MenuScreen>(MenuScreen.MENU_FRAGMENT)
    val menuScreens: StateFlow<MenuScreen> = _menuScreens

    fun loadNav(menuScreen: MenuScreen) {
        viewModelScope.launch(Dispatchers.IO) {
            _menuScreens.emit(menuScreen)
        }
    }
}