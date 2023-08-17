package com.example.gobletanoprojectapp.fragments.level

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.common_common_utils.Constants
import com.example.gobletanoprojectapp.NavigationAppViewModel
import com.example.gobletanoprojectapp.R
import com.example.gobletanoprojectapp.databinding.FragmentLevelBinding
import com.example.gobletanoprojectapp.fragments.levels.LevelsViewModel
import com.example.gobletanoprojectapp.util.MenuScreen

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LevelFragment : Fragment() {

    private lateinit var binding: FragmentLevelBinding
    private val navigationAppViewModel: NavigationAppViewModel by activityViewModels()
    private val levelViewModel: LevelViewModel by activityViewModels()
    private val levelsViewModel: LevelsViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLevelBinding.inflate(inflater, container, false)
        binding.btnBackLevel.setOnClickListener {
            navigationAppViewModel.loadNav(MenuScreen.MENU_FRAGMENT)
        }
        lifecycleScope.launch {
            for (i in 19 downTo 0){
                if (i >= 10)
                    binding.tvTime.text = "00:${i}"
                else
                    binding.tvTime.text = "00:0${i}"
                delay(1000)
            }
            navigationAppViewModel.loadNav(MenuScreen.LOSE_FRAGMENT)
        }
        lifecycleScope.launch {
            levelViewModel.level.collect {
                when(it) {
                    1 -> binding.tvLvl.setImageResource(R.drawable.icon_level_1)
                    2 -> binding.tvLvl.setImageResource(R.drawable.icon_level_2)
                    3 -> binding.tvLvl.setImageResource(R.drawable.icon_level_3)
                    4 -> binding.tvLvl.setImageResource(R.drawable.icon_level_4)
                    5 -> binding.tvLvl.setImageResource(R.drawable.icon_level_5)
                    6 -> binding.tvLvl.setImageResource(R.drawable.icon_level_6)
                }
            }
        }
        val level = levelViewModel.level.value - 1
        if (Constants.level[level][0][0] == 0)
            binding.img0.visibility = View.INVISIBLE
        if (Constants.level[level][0][1] == 0)
            binding.img01.visibility = View.INVISIBLE
        if (Constants.level[level][0][2] == 0)
            binding.img02.visibility = View.INVISIBLE
        if (Constants.level[level][1][0] == 0)
            binding.img10.visibility = View.INVISIBLE
        if (Constants.level[level][1][1] == 0)
            binding.img11.visibility = View.INVISIBLE
        if (Constants.level[level][1][2] == 0)
            binding.img12.visibility = View.INVISIBLE
        if (Constants.level[level][2][0] == 0)
            binding.img20.visibility = View.INVISIBLE
        if (Constants.level[level][2][1] == 0)
            binding.img21.visibility = View.INVISIBLE
        if (Constants.level[level][2][2] == 0)
            binding.img22.visibility = View.INVISIBLE
        if (Constants.level[level][3][0] == 0)
            binding.img30.visibility = View.INVISIBLE
        if (Constants.level[level][3][1] == 0)
            binding.img31.visibility = View.INVISIBLE
        if (Constants.level[level][3][2] == 0)
            binding.img32.visibility = View.INVISIBLE
        if (Constants.level[level][4][0] == 0)
            binding.img40.visibility = View.INVISIBLE
        if (Constants.level[level][4][1] == 0)
            binding.img41.visibility = View.INVISIBLE
        if (Constants.level[level][4][2] == 0)
            binding.img42.visibility = View.INVISIBLE

        binding.img0.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][0][0]) {
                1 -> binding.img0.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img0.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img01.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][0][1]) {
                1 -> binding.img01.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img01.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img02.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][0][2]) {
                1 -> binding.img02.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img02.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.img10.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][1][0]) {
                1 -> binding.img10.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img10.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img11.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][1][1]) {
                1 -> binding.img11.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img11.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img12.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][1][2]) {
                1 -> binding.img12.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img12.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.img20.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][2][0]) {
                1 -> binding.img20.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img20.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img21.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][2][1]) {
                1 -> binding.img21.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img21.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img22.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][2][2]) {
                1 -> binding.img22.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img22.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.img30.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][3][0]) {
                1 -> binding.img30.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img30.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img31.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][3][1]) {
                1 -> binding.img31.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img31.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img32.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][3][2]) {
                1 -> binding.img32.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img32.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }

        binding.img40.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][4][0]) {
                1 -> binding.img40.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img40.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img41.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][4][1]) {
                1 -> binding.img41.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img41.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        binding.img42.setOnClickListener {
            iconCupOff()
            when(Constants.level[level][4][2]) {
                1 -> binding.img42.setImageResource(R.drawable.icon_white_cup)
                2 -> {
                    binding.img42.setImageResource(R.drawable.icon_yellow_cup)
                    goToWinFragment()
                }
            }
        }
        return binding.root
    }
    private fun goToWinFragment() {
        levelViewModel.loadState(Integer.min(levelViewModel.level.value + 1, 6))
        levelsViewModel.loadState(Integer.min(levelsViewModel.level.value + 1, 6))
        //Thread.sleep(1_000)
        navigationAppViewModel.loadNav(MenuScreen.WIN_FRAGMENT)
    }

    private fun iconCupOff() {
        binding.img0.setImageResource(R.drawable.icon_off_cup)
        binding.img01.setImageResource(R.drawable.icon_off_cup)
        binding.img02.setImageResource(R.drawable.icon_off_cup)

        binding.img10.setImageResource(R.drawable.icon_off_cup)
        binding.img11.setImageResource(R.drawable.icon_off_cup)
        binding.img12.setImageResource(R.drawable.icon_off_cup)

        binding.img20.setImageResource(R.drawable.icon_off_cup)
        binding.img21.setImageResource(R.drawable.icon_off_cup)
        binding.img22.setImageResource(R.drawable.icon_off_cup)

        binding.img30.setImageResource(R.drawable.icon_off_cup)
        binding.img31.setImageResource(R.drawable.icon_off_cup)
        binding.img32.setImageResource(R.drawable.icon_off_cup)

        binding.img40.setImageResource(R.drawable.icon_off_cup)
        binding.img41.setImageResource(R.drawable.icon_off_cup)
        binding.img42.setImageResource(R.drawable.icon_off_cup)

    }
}