package com.watermelon.moviesapp.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentCategoriesBinding


class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // SET CATEGORIES RECYCLER ADAPTER
        binding.categoriesRecycler.adapter = CategoriesAdapter(mutableListOf(), viewModel)

        // NAVIGATE TO DISPLAY CATEGORY
        viewModel.navigateToCategoriesDisplay.observe(
            viewLifecycleOwner,
            EventObserver { onNavigate(it) })
    }

    override val viewModel: CategoriesViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesBinding
        get() = FragmentCategoriesBinding::inflate


    private fun onNavigate(movieId: Int) {
        val action =
            CategoriesFragmentDirections.actionCategoriesFragmentToCategoriesDisplayFragment(
                movieId
            )
        findNavController().navigate(action)
    }
}