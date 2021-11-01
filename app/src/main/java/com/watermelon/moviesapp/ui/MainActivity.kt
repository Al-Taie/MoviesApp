package com.watermelon.moviesapp.ui

import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.watermelon.moviesapp.ui.base.BaseActivity
import com.watermelon.moviesapp.utils.onNavDestinationSelected
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_MoviesApp
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun setup() {}

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_container_view)

        binding.bubbleTabBar.addBubbleListener { id ->
            onNavDestinationSelected(id, navController)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bubbleTabBar.setSelectedWithId(destination.id, false)
        }
    }


}