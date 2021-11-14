package com.watermelon.moviesapp.model.response

import com.google.gson.annotations.SerializedName
import com.watermelon.moviesapp.model.response.Movies

data class SimilarResponse (
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val movies: List<Movies>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)