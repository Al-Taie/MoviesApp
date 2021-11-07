package com.watermelon.moviesapp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.watermelon.moviesapp.main.test.NestedAdapter
import com.watermelon.moviesapp.model.response.movie.Movie
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.home.MovieInteractionListener
import watermelon.moviesapp.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(), MovieInteractionListener {
    override fun setup() {
        val items = listOf(
            Movie(null, null, null, 4,
                null, null, null, null,
                null, null, null,
                "TEST1", null, null, null),

            Movie(null, null, null, 4,
            null, null, null, null,
            null, null, null,
            "TEST2", null, null, null)
        )

        val items1 = listOf(
            Movie(null, null, null, 4,
                null, null, null, null,
                null, null, null,
                "TEST3", null, null, null),

            Movie(null, null, null, 4,
                null, null, null, null,
                null, null, null,
                "TEST4", null, null, null)
        )

        val items3 = listOf(items, items1)
        binding.adapter = NestedAdapter(items3, this)
    }

    override val viewModel: MainViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    override fun onItemClicked(movieId: Int) {
        //
    }
}