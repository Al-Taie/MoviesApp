package com.watermelon.moviesapp.ui.famous

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.Event
import watermelon.moviesapp.databinding.FragmentFamousBinding

class FamousFragment : BaseFragment<FragmentFamousBinding>() {
    override val viewModel: FamousViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentFamousBinding
        get() = FragmentFamousBinding::inflate

    override fun setup() {
        binding.viewModel = viewModel
        binding.popularRecyclerDisplay.adapter = FamousAdapter(mutableListOf(), viewModel)
        viewModel.navigateToProfile.observe(this, ::onNavigate)
    }

    private fun onNavigate(event: Event<Int>) {
        event.getContentIfNotHandled()?.let { movieId ->
            val action = FamousFragmentDirections.actionPopularFragmentToProfileFragment(movieId)
            findNavController().navigate(action)
        }
    }
}