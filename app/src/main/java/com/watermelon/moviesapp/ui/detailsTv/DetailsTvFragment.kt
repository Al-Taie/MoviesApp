package com.watermelon.moviesapp.ui.detailsTv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentDetailsTvBinding


class DetailsTvFragment : BaseFragment<FragmentDetailsTvBinding>() {

    override val viewModel: DetailsTvViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsTvBinding
        get() = FragmentDetailsTvBinding::inflate

    private val args: DetailsTvFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemLoad(args.tvId)
        initViewPager()
        initTabLayout()
        addBottomSheet()
    }

    private fun initTabLayout() {
        val tabTitles = listOf("About", "Seasons", "More")
        TabLayoutMediator(binding.tabLayout, binding.detailsTvViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        val fragmentList = listOf(
            AboutTvFragment(),
            SeasonsTvFragment(),
            MoreDetailsFragment()
        )

        binding.detailsTvViewPager.adapter = DetailsTvViewPager(this, fragmentList)
    }

    private fun addBottomSheet() {
        BottomSheetBehavior.from(binding.detailsMovie).apply {
            peekHeight = 450
            state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}