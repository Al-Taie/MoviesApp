package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentCategoriesDisplayBinding

class CategoriesDisplayFragment : BaseFragment<FragmentCategoriesDisplayBinding>() {
    override val viewModel: CategoriesDisplayViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesDisplayBinding
        get() = FragmentCategoriesDisplayBinding::inflate

    private val args: CategoriesDisplayFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMoviesOfOneGenre(args.movieId)
        binding.categoriesRecyclerDisplay.adapter =
            CategoriesDisplayAdapter(mutableListOf(), viewModel)
        binding.goBack.setOnClickListener { findNavController().navigateUp() }
        viewModel.navigateToDetailsFromCategories.observe(
            viewLifecycleOwner, EventObserver { onNavigate(it) })
    }

    private fun onNavigate(movieID: Int) {
        val action =
            CategoriesDisplayFragmentDirections.actionCategoriesDisplayFragmentToDetailsFragment(
                movieID
            )
        findNavController().navigate(action)
    }
}