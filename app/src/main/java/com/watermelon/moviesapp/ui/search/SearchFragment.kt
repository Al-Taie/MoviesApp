package com.watermelon.moviesapp.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import com.watermelon.moviesapp.viewModels.SearchViewModel
import watermelon.moviesapp.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {


    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {
        binding.searchRecyclerView.adapter =SearchAdapter(mutableListOf(),viewModel)
        Log.i("search", viewModel.movieTitle.toString())

        viewModel.movieTitle.observe(this, {
            Log.i("observe", it.toString())
        })

        viewModel.openTaskEvent.observe(this, EventObserver {
//            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(R.id.action_searchFragment_to_detailsFragment)

            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(movieId = )
            this.view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
        })
    }


}