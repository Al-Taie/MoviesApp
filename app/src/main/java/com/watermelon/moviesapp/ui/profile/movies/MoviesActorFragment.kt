package com.watermelon.moviesapp.ui.profile.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.ProfileViewModel
import watermelon.moviesapp.databinding.FragmentMoviesActorBinding

class MoviesActorFragment : BaseFragment<FragmentMoviesActorBinding>() {
    override fun setup() {
        viewModel.movieCredits.observe(this,{
            Log.v("TESTING", it.toData()?.cast.toString())
        })
    }

    override val viewModel: ProfileViewModel by viewModels ({ requireParentFragment() })
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMoviesActorBinding
        get() = FragmentMoviesActorBinding::inflate
}