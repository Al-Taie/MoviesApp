package com.watermelon.moviesapp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentMainBinding

class MainFragment:BaseFragment<FragmentMainBinding>() {
    override fun setup() {}

    override val viewModel:MainViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate
}