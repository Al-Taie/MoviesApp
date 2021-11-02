package com.watermelon.moviesapp.model.response.trending.all


import com.google.gson.annotations.SerializedName

data class TrendingAllResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TrendingAll>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)