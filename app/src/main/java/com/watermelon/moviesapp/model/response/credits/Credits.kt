package com.watermelon.moviesapp.model.response.credits


import com.google.gson.annotations.SerializedName

data class Credits(
    @SerializedName("cast")
    val cast: List<Cast>? = null,
    @SerializedName("crew")
    val crew: List<Crew>? = null,
    @SerializedName("id")
    val id: Int? = null
)