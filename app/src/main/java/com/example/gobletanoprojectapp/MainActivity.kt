package com.example.gobletanoprojectapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.gobletanoprojectapp.databinding.ActivityMainBinding
import com.example.gobletanoprojectapp.fragments.level.LevelFragment
import com.example.gobletanoprojectapp.fragments.levels.LevelsFragment
import com.example.gobletanoprojectapp.fragments.lose.LoseFragment
import com.example.gobletanoprojectapp.fragments.menu.MenuFragment
import com.example.gobletanoprojectapp.fragments.settings.SettingsFragment
import com.example.gobletanoprojectapp.fragments.settings.SettingsViewModel
import com.example.gobletanoprojectapp.fragments.statisticcs.StatisticsFragment
import com.example.gobletanoprojectapp.fragments.win.WinFragment
import com.example.gobletanoprojectapp.util.MenuScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navigationAppViewModel: NavigationAppViewModel by viewModels()
    private val settingsViewModel: SettingsViewModel by viewModels()
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true

        lifecycleScope.launch {
            navigationAppViewModel.menuScreens.collect {
                when(it){
                    MenuScreen.MENU_FRAGMENT -> replaceFragment(MenuFragment())
                    MenuScreen.LEVEL_FRAGMENT -> replaceFragment(LevelFragment())
                    MenuScreen.LEVELS_FRAGMENT -> replaceFragment(LevelsFragment())
                    MenuScreen.LOSE_FRAGMENT -> replaceFragment(LoseFragment())
                    MenuScreen.SETTINGS_FRAGMENT -> replaceFragment(SettingsFragment())
                    MenuScreen.WIN_FRAGMENT -> replaceFragment(WinFragment())
                    MenuScreen.STATISTICS_FRAGMENT -> replaceFragment(StatisticsFragment())
                }
            }
        }
        lifecycleScope.launch {
            settingsViewModel.musicOn.collect {
                when (it) {
                    "on" -> mediaPlayer.start()
                    "off" -> mediaPlayer.pause()

                    else -> {}
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}