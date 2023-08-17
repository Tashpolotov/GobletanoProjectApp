package com.example.gobletanoprojectapp.fragments.lose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.databinding.FragmentLoseBinding
import com.example.gobletanoprojectapp.util.MenuScreen


class LoseFragment : Fragment() {

    private lateinit var binding: FragmentLoseBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoseBinding.inflate(inflater, container, false)
        binding.imgLose.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.MENU_FRAGMENT)
        }
        binding.imgAgain.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
        }
        return binding.root
    }
}