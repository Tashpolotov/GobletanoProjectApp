package com.example.gobletanoprojectapp.fragments.statisticcs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.databinding.FragmentStatisticsBinding
import com.example.gobletanoprojectapp.util.MenuScreen


class StatisticsFragment : Fragment() {

    private lateinit var binding: FragmentStatisticsBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        binding.imgBack.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.MENU_FRAGMENT)
        }
        return binding.root
    }
}