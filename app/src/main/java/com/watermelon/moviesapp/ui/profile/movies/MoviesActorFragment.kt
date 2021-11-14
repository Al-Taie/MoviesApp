package com.watermelon.moviesapp.ui.profile.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Constant
import watermelon.moviesapp.databinding.FragmentMoviesActorBinding

class MoviesActorFragment : BaseFragment<FragmentMoviesActorBinding>() {
    override fun setup() {
        arguments?.getInt(Constant.ID)?.run { viewModel.onItemLoad(this) }

        binding.movieRecycler.adapter = CastMovieAdapter(emptyList(), viewModel)
    }

    override val viewModel: MoviesActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMoviesActorBinding
        get() = FragmentMoviesActorBinding::inflate
}