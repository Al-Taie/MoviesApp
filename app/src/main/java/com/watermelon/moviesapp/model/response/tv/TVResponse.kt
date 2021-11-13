package com.watermelon.moviesapp.model.response.tv


import com.google.gson.annotations.SerializedName

data class TVResponse(
    @SerializedName("results")
    val results: List<TV>?
)