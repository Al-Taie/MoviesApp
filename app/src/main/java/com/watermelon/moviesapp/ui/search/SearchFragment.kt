package com.watermelon.moviesapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.viewModels.SearchViewModel
import watermelon.moviesapp.BR
import watermelon.moviesapp.databinding.SearchFragmentBinding

class SearchFragment : BaseFragment<SearchFragmentBinding>() {

    override fun setup() {}

    override val viewModelID = BR.viewModel
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> SearchFragmentBinding
        get() = SearchFragmentBinding::inflate
}