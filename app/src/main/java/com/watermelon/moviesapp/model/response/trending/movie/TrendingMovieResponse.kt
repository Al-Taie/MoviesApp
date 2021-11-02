package com.watermelon.moviesapp.model.response.trending.movie


import com.google.gson.annotations.SerializedName

data class TrendingMovieResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TrendingMovie>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)