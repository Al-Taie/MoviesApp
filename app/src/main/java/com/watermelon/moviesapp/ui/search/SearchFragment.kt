package com.watermelon.moviesapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
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
        binding.viewModel = viewModel
        binding.searchRecyclerView.adapter =SearchAdapter(mutableListOf(), viewModel)
        viewModel.navigateToDetails.observe(this, ::onNavigate)
    }

    override fun onResume() {
        super.onResume()
        binding.searchBar.requestFocus()
    }

    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let {  movieId ->
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(movieId)
            findNavController().navigate(action)
        }
    }
}