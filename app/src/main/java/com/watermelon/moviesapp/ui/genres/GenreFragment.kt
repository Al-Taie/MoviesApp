package com.watermelon.moviesapp.ui.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import watermelon.moviesapp.databinding.FragmentGenresBinding

class GenreFragment  : BaseFragment<FragmentGenresBinding>() {
    private val args: GenreFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemLoad(args.genreId)

    }

    override val viewModel : GenreViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentGenresBinding
        get() =  FragmentGenresBinding::inflate
}