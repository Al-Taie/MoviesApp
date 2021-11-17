package com.watermelon.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.tv.TvFragmentDirections
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun setup() {
        initRecyclers()
        observe()

    }

    private fun initRecyclers() {

        binding.tradingRecycler.adapter = TradingMoviesAdapter(mutableListOf(), viewModel)
        binding.popularRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.upcomingRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.topRatedRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
    }

    private fun observe(){
        viewModel.run {
            navigateToDetails.observe(this@HomeFragment, EventObserver { onNavigate(it) })
        }
    }

    private fun onNavigate(movieID: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movieID)
        findNavController().navigate(action)
    }


    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}