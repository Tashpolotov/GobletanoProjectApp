package com.example.gobletanoprojectapp.fragments.levels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.R
import com.example.gobletanoprojectapp.databinding.FragmentLevelsBinding
import com.example.gobletanoprojectapp.fragments.level.LevelViewModel
import com.example.gobletanoprojectapp.util.MenuScreen
import kotlinx.coroutines.launch

class LevelsFragment : Fragment() {

    private lateinit var binding: FragmentLevelsBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()
    private val levelsViewModel: LevelsViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevelsBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            levelsViewModel.level.collect {
                binding.imgLvl2.setImageResource(R.drawable.button_second_level_off)
                binding.imgLvl3.setImageResource(R.drawable.button_three_level_off)
                binding.imgLvl4.setImageResource(R.drawable.button_four_level_off)
                binding.imgLvl5.setImageResource(R.drawable.button_five_level_off)
                binding.imgLvl6.setImageResource(R.drawable.button_six_level_off)
                when (it) {
                    6 -> {
                        binding.imgLvl2.setImageResource(R.drawable.button_second_level_on)
                        binding.imgLvl3.setImageResource(R.drawable.button_three_level_on)
                        binding.imgLvl4.setImageResource(R.drawable.button_four_level_on)
                        binding.imgLvl5.setImageResource(R.drawable.button_five_level_on)
                        binding.imgLvl6.setImageResource(R.drawable.button_six_level_on)
                    }

                    5 -> {
                        binding.imgLvl2.setImageResource(R.drawable.button_second_level_on)
                        binding.imgLvl3.setImageResource(R.drawable.button_three_level_on)
                        binding.imgLvl4.setImageResource(R.drawable.button_four_level_on)
                        binding.imgLvl5.setImageResource(R.drawable.button_five_level_on)
                    }

                    4 -> {
                        binding.imgLvl2.setImageResource(R.drawable.button_second_level_on)
                        binding.imgLvl3.setImageResource(R.drawable.button_three_level_on)
                        binding.imgLvl4.setImageResource(R.drawable.button_four_level_on)
                    }

                    3 -> {
                        binding.imgLvl2.setImageResource(R.drawable.button_second_level_on)
                        binding.imgLvl3.setImageResource(R.drawable.button_three_level_on)
                    }

                    2 -> {
                        binding.imgLvl2.setImageResource(R.drawable.button_second_level_on)
                    }
                }
            }
        }
        binding.imgLvl1.setOnClickListener {
            if (levelViewModel.level.value >= 1) {
                levelViewModel.loadState(1)
                navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
            }
        }
        binding.imgLvl2.setOnClickListener {
            if (levelViewModel.level.value >= 2) {
                levelViewModel.loadState(2)
                navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
            }
        }
        binding.imgLvl3.setOnClickListener {
            if (levelViewModel.level.value >= 3) {
                levelViewModel.loadState(3)
                navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
            }
        }
        binding.imgLvl4.setOnClickListener {
            if (levelViewModel.level.value >= 4) {
                levelViewModel.loadState(4)
                navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
            }
        }
        binding.imgLvl5.setOnClickListener {
            if (levelViewModel.level.value >= 5) {
                levelViewModel.loadState(5)
                navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
            }
        }
        binding.imgLvl6.setOnClickListener {
            if (levelViewModel.level.value >= 6) {
                levelViewModel.loadState(6)
                navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
            }
        }
        binding.btnBackMenu.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.LEVEL_FRAGMENT)
        }
        return binding.root
    }
}