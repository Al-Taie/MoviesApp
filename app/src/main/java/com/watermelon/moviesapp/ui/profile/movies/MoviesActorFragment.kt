package com.watermelon.moviesapp.ui.profile.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentMoviesActorBinding

class MoviesActorFragment : BaseFragment<FragmentMoviesActorBinding>() {
    override fun setup() {
        Log.i("ffff" , " rrrrrrrrr")
    }

    override val viewModel: MoviesActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMoviesActorBinding
        get() = FragmentMoviesActorBinding::inflate
}