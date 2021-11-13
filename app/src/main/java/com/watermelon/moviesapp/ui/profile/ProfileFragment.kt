package com.watermelon.moviesapp.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.watermelon.moviesapp.ui.base.BaseFragment
import com.watermelon.moviesapp.ui.profile.about.AboutFragment
import com.watermelon.moviesapp.ui.profile.movies.MoviesActorFragment
import com.watermelon.moviesapp.ui.profile.tv_shows.TvShowsActorFragment
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private val args: ProfileFragmentArgs by navArgs()
    val fragments = listOf(AboutFragment(),MoviesActorFragment(), TvShowsActorFragment())
    val tabTitles = listOf(getString(R.string.about) , getString(R.string.movies),getString(R.string.tv_shows))


    override val viewModel: ProfileViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    override fun setup() {
        viewModel.onItemLoad(args.personId)
        initViewPager()
        initTabLayout()
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

