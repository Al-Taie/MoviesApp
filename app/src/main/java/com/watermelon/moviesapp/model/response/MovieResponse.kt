package com.watermelon.moviesapp.model.response


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<Movie>?
)