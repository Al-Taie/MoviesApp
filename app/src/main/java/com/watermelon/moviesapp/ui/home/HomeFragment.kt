package com.watermelon.moviesapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.viewModels.HomeViewModel
import watermelon.moviesapp.BR
import watermelon.moviesapp.databinding.HomeFragmentBinding


class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    override fun setup() {}

    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> HomeFragmentBinding
        get() = HomeFragmentBinding::inflate

}