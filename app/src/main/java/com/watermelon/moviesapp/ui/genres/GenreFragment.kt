package com.watermelon.moviesapp.ui.genres

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.genres.adapter.GenreAdapter
import watermelon.moviesapp.databinding.FragmentGenresBinding

class GenreFragment  : BaseFragment<FragmentGenresBinding>() {
    private val args: GenreFragmentArgs by navArgs()

    override fun setup() {
        viewModel.onItemLoad(args.genreId)
        binding.recyclerGenre.adapter = GenreAdapter(mutableListOf(), viewModel)
        viewModel.moviesOfOneGenre.observe(this,{
            Log.i("wwww", it.toData().toString())
        })

    }

    override val viewModel : GenreViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentGenresBinding
        get() =  FragmentGenresBinding::inflate
}