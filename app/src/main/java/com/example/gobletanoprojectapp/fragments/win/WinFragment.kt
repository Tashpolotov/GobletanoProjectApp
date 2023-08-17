package com.example.gobletanoprojectapp.fragments.win

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.databinding.FragmentWinBinding
import com.example.gobletanoprojectapp.util.MenuScreen


class WinFragment : Fragment() {

    private lateinit var binding: FragmentWinBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWinBinding.inflate(inflater, container, false)
        binding.imgMenu.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.MENU_FRAGMENT)
        }
        binding.imgNextLevel.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
        }
        return binding.root
    }
}