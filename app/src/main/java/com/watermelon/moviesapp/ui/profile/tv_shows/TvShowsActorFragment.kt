package com.watermelon.moviesapp.ui.profile.tv_shows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentTvShowsActorBinding


class TvShowsActorFragment : BaseFragment<FragmentTvShowsActorBinding>(){
    override fun setup() {
        TODO("Not yet implemented")
    }

    override val viewModel: TvShowsActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvShowsActorBinding
        get() = FragmentTvShowsActorBinding::inflate
}