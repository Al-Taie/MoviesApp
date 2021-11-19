package com.watermelon.moviesapp.ui.detailsTv.season

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.detailsTv.DetailsTvViewModel
import watermelon.moviesapp.databinding.FragmentSeasonsBinding


class SeasonsTvFragment : BaseFragment<FragmentSeasonsBinding>() {
    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSeasonsBinding
        get() = FragmentSeasonsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclers()
    }

    private fun initRecyclers() {
        binding.recyclerSeasons.adapter = SeasonTvAdapter(mutableListOf(), viewModel)
    }
}
