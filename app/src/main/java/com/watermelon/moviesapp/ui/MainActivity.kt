package com.watermelon.moviesapp.ui

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import com.watermelon.moviesapp.onNavDestinationSelected
import com.watermelon.moviesapp.ui.base.BaseActivity
import com.watermelon.moviesapp.ui.search.SearchFragment
import com.watermelon.moviesapp.viewModels.MainViewModel
import watermelon.moviesapp.BR
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_MoviesApp
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
    override val viewModelID = BR.viewModel

    override fun setup() {}

    override fun onResume() {
        super.onResume()
        val navController=findNavController(R.id.fragment_container_view)

        binding.bubbleTabBar.addBubbleListener { id ->
            onNavDestinationSelected(id, navController)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bubbleTabBar.setSelectedWithId(destination.id, false)
        }
    }






}