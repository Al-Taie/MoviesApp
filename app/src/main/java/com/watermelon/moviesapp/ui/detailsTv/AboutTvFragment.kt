package com.watermelon.moviesapp.ui.detailsTv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.details.CastAdapter
import com.watermelon.moviesapp.ui.details.SimilarMoviesAdapter
import watermelon.moviesapp.databinding.FragmentAboutTvBinding


class AboutTvFragment : BaseFragment<FragmentAboutTvBinding>() {

    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutTvBinding
        get() = FragmentAboutTvBinding::inflate


    override fun setup() {
        initRecyclers()
    }

    private fun initRecyclers() {
        binding.recyclerCast.adapter = CastAdapter(mutableListOf(), viewModel)
        binding.recyclerSimilar.adapter = SimilarMoviesAdapter(mutableListOf(), viewModel)
    }

}