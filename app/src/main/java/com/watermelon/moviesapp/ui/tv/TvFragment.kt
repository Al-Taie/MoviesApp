package com.watermelon.moviesapp.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentTvBinding

class TvFragment : BaseFragment<FragmentTvBinding>() {
    override fun setup() {
        binding.tvRecyclerView.adapter = TVAdapter(emptyList(), viewModel)
        viewModel.run {
            onTheAir.observe(this@TvFragment, { stream.postValue(it) })
            navigateToDetails.observe(this@TvFragment, EventObserver { onNavigate(it) })
        }
    }

    override val viewModel: TvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate

    private fun onNavigate(movieID: Int) {
            val action = TvFragmentDirections.actionTvFragmentToDetailsFragment(movieID)
            findNavController().navigate(action)
    }
}