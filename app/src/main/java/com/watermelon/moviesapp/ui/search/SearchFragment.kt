package com.watermelon.moviesapp.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.model.repository.MovieRepository
import com.watermelon.moviesapp.model.response.Movie
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.viewModels.SearchViewModel
import watermelon.moviesapp.databinding.SearchFragmentBinding

class SearchFragment : BaseFragment<SearchFragmentBinding>() {


    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> SearchFragmentBinding
        get() = SearchFragmentBinding::inflate

    override fun setup() {
//        val searchResult=viewModel.movieSearchResult as List<*>
//        binding.searchRecyclerView.adapter = SearchAdapter(searchResult as List<Movie>,viewModel)

        Log.i("search",viewModel.movieTitle.toString())
       // binding.searchRecyclerView.adapter = SearchAdapter(emptyList(),viewModel)
        viewModel.movieTitle.observe(this,{
            Log.i("searchob", it.toString())
        })
    }

    override fun onResume() {
        super.onResume()

       // Log.i("search",viewModel.movieTitle.toString())
      //  binding.searchRecyclerView.adapter = SearchAdapter(emptyList(),viewModel)
    }


}