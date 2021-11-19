package com.watermelon.moviesapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclers()
        observe()
        binding.search.setOnClickListener {
            onNavigateToSearch()
        }
        viewModel.popularMovies.observe(this, {
            when(it) {
                is State.Success -> Log.v("TESTING", it.data.toString())
                is State.Error -> Log.v("TESTING", it.message)
                is State.Loading -> Log.v("TESTING", "LODING...")
            }
            Log.v("TESTING", it.toString())
        })
    }

    private fun initRecyclers() {
        binding.tradingRecycler.adapter = TradingMoviesAdapter(mutableListOf(), viewModel)
        binding.popularRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.upcomingRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
        binding.topRatedRecycler.adapter = MoviesAdapter(mutableListOf(), viewModel)
    }

    private fun observe() {
        viewModel.navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
    }

    private fun onNavigate(movieID: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movieID) )
    }

    private fun onNavigateToSearch() {
        val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
        val extras = FragmentNavigatorExtras(binding.search to getString(R.string.search_transition))
        findNavController().navigate(action, extras)
    }

}