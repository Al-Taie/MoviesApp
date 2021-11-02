package com.watermelon.moviesapp.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.viewModels.DetailsViewModel
import watermelon.moviesapp.databinding.DetailsFragmentBinding

class DetailsFragment : BaseFragment<DetailsFragmentBinding>(){
    val args: DetailsFragmentArgs by navArgs()


    override fun setup() {
        args.movieId
    }

    override val viewModel: DetailsViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> DetailsFragmentBinding
        get() = DetailsFragmentBinding::inflate
}