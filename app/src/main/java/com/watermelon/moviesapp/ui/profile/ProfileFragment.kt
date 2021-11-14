package com.watermelon.moviesapp.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.details.DetailsFragmentDirections
import com.watermelon.moviesapp.ui.profile.about.AboutFragment
import com.watermelon.moviesapp.ui.profile.movies.MoviesActorFragment
import com.watermelon.moviesapp.ui.profile.tv.TvShowsActorFragment
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.FragmentProfileBinding
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels


class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private val args: ProfileFragmentArgs by navArgs()
    val fragments = listOf(AboutFragment(),MoviesActorFragment(),TvShowsActorFragment())
    val tabTitles = listOf("About" , "Movies","Tv Shows")



    override val viewModel: ProfileViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun setup() {
        viewModel.onItemLoad(args.personId)
        initViewPager()
        initTabLayout()
        viewModel.movieCredits.observe(this,{
            Log.i("movieC", it.toData()?.cast.toString())
        })


    }


    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout , binding.profileViewPager){ tab , position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        val pagerAdapter = ProfilePagerAdapter(this , fragments)
        binding.profileViewPager.adapter = pagerAdapter
    }

}

