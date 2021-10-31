package com.watermelon.moviesapp.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.viewModels.TvViewModel
import watermelon.moviesapp.databinding.FragmentTvBinding

class TvFragment:BaseFragment<FragmentTvBinding>() {
    override fun setup() {}

    override val viewModel:TvViewModel by  activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTvBinding
        get() = FragmentTvBinding::inflate
}