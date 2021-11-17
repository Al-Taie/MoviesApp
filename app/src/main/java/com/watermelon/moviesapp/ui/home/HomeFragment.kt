package com.watermelon.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun setup() {
        initRecyclers()


    }

    private fun initRecyclers() {

        binding.tradingRecycler.adapter = TradingMoviesAdapter(mutableListOf(), viewModel)
        binding.popularRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.upcomingRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.topRatedRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
    }

    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}