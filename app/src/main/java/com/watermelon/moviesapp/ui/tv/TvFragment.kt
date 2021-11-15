package com.watermelon.moviesapp.ui.tv

import android.view.LayoutInflater
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

    override fun setup() {
        initRecycler()
        observe()
    }

    private fun initRecycler(){
        binding.tvRecyclerView.adapter = TVAdapter(emptyList(), viewModel)
    }

    private fun observe(){
        viewModel.run {
            onTheAir.observe(this@TvFragment, { stream.postValue(it) })
            navigateToDetails.observe(this@TvFragment, EventObserver { onNavigate(it) })
        }
    }

    private fun onNavigate(tvID: Int) {
        val action = TvFragmentDirections.actionTvFragmentToDetailsTvFragment(tvID)
        findNavController().navigate(action)
    }

}