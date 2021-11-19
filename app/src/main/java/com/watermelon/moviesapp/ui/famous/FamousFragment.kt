package com.watermelon.moviesapp.ui.famous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.utils.EventObserver
import watermelon.moviesapp.databinding.FragmentFamousBinding


class FamousFragment : BaseFragment<FragmentFamousBinding>() {
    override val viewModel: FamousViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentFamousBinding
        get() = FragmentFamousBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        observe()
    }

    private fun initAdapter() {
        binding.popularRecyclerDisplay.adapter = FamousAdapter(mutableListOf(), viewModel)
    }

    private fun onNavigate(movieId: Int) {
        findNavController().navigate(
            FamousFragmentDirections.actionPopularFragmentToProfileFragment(movieId)
        )
    }

    private fun observe() {
        viewModel.navigateToProfile.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
    }
}