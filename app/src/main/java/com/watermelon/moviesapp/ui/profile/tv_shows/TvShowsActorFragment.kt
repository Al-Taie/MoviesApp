package com.watermelon.moviesapp.ui.profile.tv_shows

import android.os.Bundle
import android.util.Log
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(Constant.ID)?.run { viewModel.onItemLoad(this) }
        viewModel.navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
        binding.tvRecyclerView.adapter = CastTvAdapter(emptyList(), viewModel)

    }

    override val viewModel: TvShowsActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvShowsActorBinding
        get() = FragmentTvShowsActorBinding::inflate
    private fun onNavigate(movieID: Int) {
        val action = ProfileFragmentDirections.actionProfileFragmentToDetailsTvFragment(movieID)
        findNavController().navigate(action)
    }
}