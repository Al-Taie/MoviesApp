package com.watermelon.moviesapp.ui

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.watermelon.moviesapp.ui.base.BaseActivity
import com.watermelon.moviesapp.ui.search.SearchFragment
import com.watermelon.moviesapp.viewModels.MainViewModel
import watermelon.moviesapp.BR
import watermelon.moviesapp.R
import watermelon.moviesapp.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_MoviesApp
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
    override val viewModelID = BR.viewModel


    private val searchFragment = SearchFragment()
    override fun setup() {
        binding.btnNav.setOnClickListener {
            replaceFragment(searchFragment)
        }
    }


    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.commit()
    }

}