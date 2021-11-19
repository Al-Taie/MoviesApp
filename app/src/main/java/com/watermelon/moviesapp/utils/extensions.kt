package com.watermelon.moviesapp.utils

import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.denzcoskun.imageslider.models.SlideModel
import com.watermelon.moviesapp.model.response.trending.movie.TrendingMovie
import watermelon.moviesapp.R


fun onNavDestinationSelected(
    itemId: Int,
    navController: NavController
): Boolean {
    val builder = NavOptions.Builder()
        .setLaunchSingleTop(true)
    if (navController.currentDestination?.parent?.findNode(itemId) is ActivityNavigator.Destination) {
        builder.setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
    } else {
        builder.setEnterAnim(R.animator.nav_default_enter_anim)
            .setExitAnim(R.animator.nav_default_exit_anim)
            .setPopEnterAnim(R.animator.nav_default_pop_enter_anim)
            .setPopExitAnim(R.animator.nav_default_pop_exit_anim)
    }

    builder.setPopUpTo(itemId, true)

    return try {
        val options = builder.build()
        navController.navigate(itemId, null, options)
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}

fun TrendingMovie.toSlider(): SlideModel {
    return SlideModel(Constant.BASE_IMAGE_URL + this.posterPath, this.title)
}