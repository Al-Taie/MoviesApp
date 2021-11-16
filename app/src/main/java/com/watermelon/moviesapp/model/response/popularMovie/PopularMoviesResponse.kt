package com.watermelon.moviesapp.model.response.popularMovie



import com.watermelon.moviesapp.model.response.popularMovie.Result
import com.google.gson.annotations.SerializedName


data class PopularMoviesResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<Result>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)