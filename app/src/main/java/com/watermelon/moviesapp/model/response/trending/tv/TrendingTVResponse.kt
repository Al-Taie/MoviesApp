package com.watermelon.moviesapp.model.response.trending.tv


import com.google.gson.annotations.SerializedName

data class TrendingTVResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TrendingTV>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)