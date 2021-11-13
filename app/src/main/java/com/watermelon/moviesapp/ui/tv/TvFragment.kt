package com.watermelon.moviesapp.ui.tv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.model.State
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentTvBinding

class TvFragment : BaseFragment<FragmentTvBinding>() {

    override fun setup() {
        binding.tvRecyclerView.adapter = TVAdapter(emptyList(), viewModel)
        viewModel.run {
            onTheAir.observe(this@TvFragment, { stream.postValue(it) })
        }
    }

    override val viewModel: TvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate
}