package com.watermelon.moviesapp.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentCategoriesBinding


class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {


    override fun setup() {

        binding.viewModel = viewModel
        binding.categoriesRecycler.adapter = CategoriesAdapter(mutableListOf(), viewModel)
        viewModel.navigateToCategoriesDisplay.observe(this, ::onNavigate)
    }

    override val viewModel: CategoriesViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesBinding
        get() = FragmentCategoriesBinding::inflate


    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let { movieId ->
            val action =
                CategoriesFragmentDirections.actionCategoriesFragmentToCategoriesDisplayFragment(
                    movieId
                )
            findNavController().navigate(action)
        }
    }
}