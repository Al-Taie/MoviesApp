package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.details.CastAdapter
import watermelon.moviesapp.databinding.FragmentCategoriesDisplayBinding

class CategoriesDisplayFragment : BaseFragment<FragmentCategoriesDisplayBinding>() {

    private val args: CategoriesDisplayFragmentArgs by navArgs()
    override fun setup() {
        viewModel.onItemClick(args.movieId)
        binding.categoriesRecyclerDisplay.adapter = CategoriesDisplayAdapter(mutableListOf(), viewModel)
    }

    override val viewModel: CategoriesDisplayViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesDisplayBinding
        get() = FragmentCategoriesDisplayBinding::inflate
}