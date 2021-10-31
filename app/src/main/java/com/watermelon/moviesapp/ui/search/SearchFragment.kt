package com.watermelon.moviesapp.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.viewModels.SearchViewModel
import watermelon.moviesapp.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {


    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {


        Log.i("search", viewModel.movieTitle.toString())

        viewModel.movieTitle.observe(this, {
            Log.i("observe", it.toString())
        })
    }


}