package com.watermelon.moviesapp.ui.detailsTv.moreDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.detailsTv.about.DetailsTvViewModel
import com.watermelon.moviesapp.ui.detailsTv.moreDetails.MoreDetailsAdapter
import watermelon.moviesapp.databinding.FragmentMoreDetailsBinding

class MoreDetailsFragment : BaseFragment<FragmentMoreDetailsBinding>() {

    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMoreDetailsBinding
        get() = FragmentMoreDetailsBinding::inflate


    override fun setup() {
        initRecyclers()
    }

    private fun initRecyclers() {
        binding.recyclerCompanies.adapter = MoreDetailsAdapter(mutableListOf(), viewModel)
    }

}