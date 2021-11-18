package com.watermelon.moviesapp.model.response.tvCredits


import com.google.gson.annotations.SerializedName

data class TvCreditsResponse(
    @SerializedName("cast")
    val cast: List<Cast>?,
    @SerializedName("crew")
    val crew: List<Crew>?,
    @SerializedName("id")
    val id: Int?
)