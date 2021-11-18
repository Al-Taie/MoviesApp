package com.watermelon.moviesapp.ui.profile.tv_shows

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Constant
import watermelon.moviesapp.databinding.FragmentTvShowsActorBinding


class TvShowsActorFragment : BaseFragment<FragmentTvShowsActorBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(Constant.ID)?.run { viewModel.onItemLoad(this) }
        binding.tvRecyclerView.adapter = CastTvAdapter(emptyList(), viewModel)
        viewModel.tvCredits.observe(viewLifecycleOwner , {
            Log.i("soso", it.toData()?.cast.toString())
        })
    }

    override val viewModel: TvShowsActorViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvShowsActorBinding
        get() = FragmentTvShowsActorBinding::inflate
}