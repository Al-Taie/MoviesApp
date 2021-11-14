package com.watermelon.moviesapp.ui.profile

import android.app.Activity
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProfilePagerAdapter(container : ProfileFragment ,private val fragmentList : List<Fragment>) : FragmentStateAdapter(container) {
    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]
}