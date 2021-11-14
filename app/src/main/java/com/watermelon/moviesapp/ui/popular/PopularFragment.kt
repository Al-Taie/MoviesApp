package com.watermelon.moviesapp.ui.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentPopulerBinding

class PopularFragment : BaseFragment<FragmentPopulerBinding>() {
    override fun setup() {

    }

    override val viewModel: PopularViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentPopulerBinding
        get() = FragmentPopulerBinding::inflate
}