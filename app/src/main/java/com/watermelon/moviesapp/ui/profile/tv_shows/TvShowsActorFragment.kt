package com.watermelon.moviesapp.ui.profile.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.ProfileFragmentDirections
import com.watermelon.moviesapp.utils.Constant
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentTvShowsActorBinding


class TvShowsActorFragment : BaseFragment<FragmentTvShowsActorBinding>() {

    override val viewModel: TvShowsActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvShowsActorBinding
        get() = FragmentTvShowsActorBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt(Constant.ID)?.run { viewModel.onItemLoad(this) }
        initAdapter()
        observe()
    }

    private fun initAdapter() {
        binding.tvRecyclerView.adapter = CastTvAdapter(emptyList(), viewModel)
    }

    private fun observe() {
        viewModel.navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
    }

    private fun onNavigate(movieID: Int) {
        findNavController().navigate( ProfileFragmentDirections
            .actionProfileFragmentToDetailsTvFragment(movieID))
    }

}