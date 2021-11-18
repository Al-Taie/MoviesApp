package com.watermelon.moviesapp.ui.detailsTv.moredetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.detailsTv.DetailsTvViewModel
import watermelon.moviesapp.databinding.FragmentMoreDetailsBinding

class MoreDetailsFragment : BaseFragment<FragmentMoreDetailsBinding>() {
    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMoreDetailsBinding
        get() = FragmentMoreDetailsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclers()
    }

    private fun initRecyclers() {
        binding.recyclerCompanies.adapter = MoreDetailsAdapter(mutableListOf(), viewModel)
    }
}