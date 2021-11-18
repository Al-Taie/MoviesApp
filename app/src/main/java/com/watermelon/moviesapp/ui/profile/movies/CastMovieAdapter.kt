package com.watermelon.moviesapp.ui.profile.movies

import com.watermelon.moviesapp.model.response.movieCredits.Cast
import com.watermelon.moviesapp.ui.base.BaseAdapter
import com.watermelon.moviesapp.ui.profile.ProfileInteractionListener
import watermelon.moviesapp.R

class CastMovieAdapter(list: List<Cast>, listener: ProfileInteractionListener) :
    BaseAdapter<Cast>(list, listener) {

    override var layoutID = R.layout.item_movies_actor
}