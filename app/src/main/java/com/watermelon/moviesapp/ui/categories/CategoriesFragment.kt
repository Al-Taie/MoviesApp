package com.watermelon.moviesapp.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentCategoriesBinding

class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {
    override fun setup() {}

    override val viewModel : CategoriesViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesBinding
        get() = FragmentCategoriesBinding::inflate
}