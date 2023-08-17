package com.example.gobletanoprojectapp.fragments.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.R
import com.example.gobletanoprojectapp.databinding.FragmentMenuBinding
import com.example.gobletanoprojectapp.util.MenuScreen


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.btnLevels.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.LEVELS_FRAGMENT)
        }
        binding.btnPlay.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
        }
        binding.btnSettings.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.SETTINGS_FRAGMENT)
        }
        binding.btnStatistics.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.STATISTICS_FRAGMENT)
        }

        return binding.root
    }

}