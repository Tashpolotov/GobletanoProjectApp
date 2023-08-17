package com.example.gobletanoprojectapp.fragments.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.databinding.FragmentSettingsBinding
import com.example.gobletanoprojectapp.util.MenuScreen
import kotlinx.coroutines.launch


class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()
    private val settingsViewModel: SettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.btnBackSettings.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.MENU_FRAGMENT)
        }
        lifecycleScope.launch {
            settingsViewModel.musicOn.collect {
                when (it) {
                    "on" -> {
                        binding.imgOnSound.visibility = View.VISIBLE
                        binding.imgOffSound.visibility = View.INVISIBLE
                    }
                    "off" -> {
                        binding.imgOffSound.visibility = View.VISIBLE
                        binding.imgOnSound.visibility = View.INVISIBLE
                    }
                }
            }
        }
        binding.imgOnSound.setOnClickListener {
            settingsViewModel.loadState("off")
        }
        binding.imgOffSound.setOnClickListener {
            settingsViewModel.loadState("on")
        }
        return binding.root
    }
}