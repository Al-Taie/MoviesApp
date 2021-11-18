package com.watermelon.moviesapp.ui.detailsTv.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.details.CastAdapter
import com.watermelon.moviesapp.ui.detailsTv.DetailsTvFragmentDirections
import com.watermelon.moviesapp.ui.detailsTv.DetailsTvViewModel
import com.watermelon.moviesapp.ui.detailsTv.about.similartv.SimilarTVAdapter
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentAboutTvBinding


class AboutTvFragment : BaseFragment<FragmentAboutTvBinding>() {

    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutTvBinding
        get() = FragmentAboutTvBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclers()
        observe()
    }

    private fun initRecyclers() {
        binding.recyclerCast.adapter = CastTvAdapter(mutableListOf(), viewModel)
        binding.recyclerSimilar.adapter = SimilarTVAdapter(mutableListOf(), viewModel)
    }

    private fun onNavigate(personId: Int) {
        val action = DetailsTvFragmentDirections.actionDetailsTvFragmentToProfileFragment(personId)
        findNavController().navigate(action)
    }
    private fun onNavigateToItSelf(movieId: Int) {
        val action = DetailsTvFragmentDirections.actionDetailsTvFragmentToDetailsTvFragment(movieId)
        findNavController().navigate(action)
    }

    private fun observe(){
        viewModel.apply {
            navigateToProfile.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
            navigateToItSelf.observe(viewLifecycleOwner, EventObserver { onNavigateToItSelf(it)})
        }
    }
}