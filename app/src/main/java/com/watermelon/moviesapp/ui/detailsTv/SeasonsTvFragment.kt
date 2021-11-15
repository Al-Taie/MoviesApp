package com.watermelon.moviesapp.ui.detailsTv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentSeasonsBinding


class SeasonsTvFragment : BaseFragment<FragmentSeasonsBinding>() {

    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSeasonsBinding
        get() = FragmentSeasonsBinding::inflate


    override fun setup() {
        initRecyclers()
    }

    private fun initRecyclers() {
        binding.recyclerSeasons.adapter = SeasonTvAdapter(mutableListOf(), viewModel)
    }

}