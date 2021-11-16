package com.watermelon.moviesapp.ui.profile

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.about.AboutFragment
import com.watermelon.moviesapp.ui.profile.movies.MoviesActorFragment
import com.watermelon.moviesapp.ui.profile.tv_shows.TvShowsActorFragment
import com.watermelon.moviesapp.utils.Constant
import watermelon.moviesapp.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private val args: ProfileFragmentArgs by navArgs()

    override val viewModel: ProfileViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun setup() {
        viewModel.onItemLoad(args.personId)
        initViewPager()
        initTabLayout()
        binding.goBack.setOnClickListener { findNavController().navigateUp() }
    }

    private fun initTabLayout() {
        val tabTitles = listOf("About", "Movies", "Tv Shows")

        TabLayoutMediator(binding.tabLayout, binding.profileViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        val bundle = Bundle().apply { putInt(Constant.ID, args.personId) }
        val fragments = listOf(AboutFragment(),
            MoviesActorFragment(),
            TvShowsActorFragment()).map { it.apply { arguments = bundle } }
        binding.profileViewPager.adapter = ProfilePagerAdapter(this, fragments)
    }

}

