package com.watermelon.moviesapp.ui.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentPopularBinding

class PopularFragment : BaseFragment<FragmentPopularBinding>() {


    override val viewModel: PopularViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentPopularBinding
        get() = FragmentPopularBinding::inflate

    override fun setup() {
        binding.viewModel = viewModel
        binding.popularRecyclerDisplay.adapter = PopularAdapter(mutableListOf(), viewModel)
        viewModel.navigateToProfile.observe(this, ::onNavigate)
    }


    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let { movieId ->
            val action = PopularFragmentDirections.actionPopularFragmentToProfileFragment(movieId)
            findNavController().navigate(action)
        }
    }
}