package com.watermelon.moviesapp.ui.profile.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.ProfileFragmentDirections
import com.watermelon.moviesapp.utils.Constant
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentMoviesActorBinding

class MoviesActorFragment : BaseFragment<FragmentMoviesActorBinding>() {
    override fun setup() {
        arguments?.getInt(Constant.ID)?.run { viewModel.onItemLoad(this) }
        viewModel.navigateToDetails.observe(this, EventObserver { onNavigate(it) })
        binding.movieRecycler.adapter = CastMovieAdapter(emptyList(), viewModel)
    }

    override val viewModel: MoviesActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMoviesActorBinding
        get() = FragmentMoviesActorBinding::inflate

    private fun onNavigate(movieID: Int) {
        val action = ProfileFragmentDirections.actionProfileFragmentToDetailsFragment(movieID)
        findNavController().navigate(action)
    }
}