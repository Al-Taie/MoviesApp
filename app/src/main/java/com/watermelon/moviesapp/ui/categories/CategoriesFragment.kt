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

    override val viewModel: CategoriesViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesBinding
        get() = FragmentCategoriesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        observe()
    }

    private fun initAdapter() {
        binding.categoriesRecycler.adapter = CategoriesAdapter(mutableListOf(), viewModel)
    }

    private fun observe() {
        viewModel.navigateToCategoriesDisplay.observe(
            viewLifecycleOwner,
            EventObserver { onNavigate(it) })
    }

    private fun onNavigate(movieId: Int) {
        findNavController().navigate(
            CategoriesFragmentDirections.actionCategoriesFragmentToCategoriesDisplayFragment(movieId)
        )
    }

}