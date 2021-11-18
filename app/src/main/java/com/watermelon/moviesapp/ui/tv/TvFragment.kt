package com.watermelon.moviesapp.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentTvBinding


class TvFragment : BaseFragment<FragmentTvBinding>() {
    override val viewModel: TvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observe()
    }

    private fun initRecycler() {
        binding.tvRecyclerView.adapter = TVAdapter(emptyList(), viewModel)
    }

    private fun observe() {
        viewModel.run {
            onTheAir.observe(viewLifecycleOwner, { stream.postValue(it) })
            navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
        }
    }

    private fun onNavigate(tvID: Int) {
        val action = TvFragmentDirections.actionTvFragmentToDetailsTvFragment(tvID)
        findNavController().navigate(action)
    }
}