package com.watermelon.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.details.CastAdapter
import com.watermelon.moviesapp.ui.details.SimilarMoviesAdapter
import watermelon.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun setup() {
        initRecyclers()


    }
    private fun initRecyclers() {
        binding.popularRecycler.adapter = PopularMovieAdapter(mutableListOf(), viewModel)
        binding.upcomingRecycler.adapter = UpcomingMoviesAdapter(mutableListOf(), viewModel)
    }


    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}