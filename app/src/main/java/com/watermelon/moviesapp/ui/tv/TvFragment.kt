package com.watermelon.moviesapp.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentTvBinding

class TvFragment : BaseFragment<FragmentTvBinding>() {

    override fun setup() {
        binding.tvRecyclerView.apply {
//            adapter = TvChannelAdapter(emptyList(), viewModel)
            layoutManager = CarouselLayoutManager(CarouselLayoutManager.VERTICAL).apply {
                setPostLayoutListener(CarouselZoomPostLayoutListener())
                setHasFixedSize(true)
            }
        }
    }

    override val viewModel: TvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate
}