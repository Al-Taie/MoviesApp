package com.watermelon.moviesapp.ui.categories.categoriesdisplay

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Constant
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentCategoriesDisplayBinding

class CategoriesDisplayFragment : BaseFragment<FragmentCategoriesDisplayBinding>() {

    override val viewModel: CategoriesDisplayViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCategoriesDisplayBinding
        get() = FragmentCategoriesDisplayBinding::inflate


    private val args: CategoriesDisplayFragmentArgs by navArgs()

    override fun setup() {
        viewModel.getMoviesOfOneGenre(args.movieId)
        binding.categoriesRecyclerDisplay.adapter =
            CategoriesDisplayAdapter(mutableListOf(), viewModel)

        viewModel.navigateToDetailsFromCategories.observe(this, ::onNavigate)

    }

    private fun onNavigate(event: Event<Int>) {

        event.getContentIfNotHandled()?.let { movieId ->
            Log.i("movieId",movieId.toString())
            val action =
                CategoriesDisplayFragmentDirections.actionCategoriesDisplayFragmentToDetailsFragment(
                    movieId
                )


            findNavController().navigate(action)
        }
    }


}