package com.watermelon.moviesapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclers()
        observe()
    }

    private fun initRecyclers() {
        binding.apply {
            tradingRecycler.adapter = TradingMoviesAdapter(mutableListOf(), viewModel)
            popularRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
            upcomingRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
            topRatedRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        }
    }

    private fun observe(){
        viewModel.navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
    }

    private fun onNavigate(movieID: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movieID)
        findNavController().navigate(action)
    }


    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}