package com.watermelon.moviesapp.model.response.movie

import com.google.gson.annotations.SerializedName
import com.watermelon.moviesapp.model.response.BaseSimilarResponse
import com.watermelon.moviesapp.model.response.Movies

data class MovieSimilarResponse (
    @SerializedName("results")
    val movies: List<Movies>? = null,
) : BaseSimilarResponse()