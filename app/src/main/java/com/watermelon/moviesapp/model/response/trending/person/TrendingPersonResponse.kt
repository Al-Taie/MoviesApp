package com.watermelon.moviesapp.model.response.trending.person


import com.google.gson.annotations.SerializedName

data class TrendingPersonResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TrendingPerson>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)