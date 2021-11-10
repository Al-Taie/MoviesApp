package com.watermelon.moviesapp.ui.search

import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {

        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)
        binding.searchBar.requestFocus()
        binding.viewModel = viewModel
        binding.searchRecyclerView.adapter =SearchAdapter(mutableListOf(), viewModel)
        viewModel.navigateToDetails.observe(this, ::onNavigate)
    }


    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let {  movieId ->
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(movieId)
            findNavController().navigate(action)
        }
    }
}