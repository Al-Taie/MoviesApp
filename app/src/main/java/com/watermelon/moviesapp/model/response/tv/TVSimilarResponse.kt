package com.watermelon.moviesapp.model.response.tv

import com.google.gson.annotations.SerializedName
import com.watermelon.moviesapp.model.response.BaseSimilarResponse

data class TVSimilarResponse (
    @SerializedName("results")
    val tv: List<TV>? = null,
) : BaseSimilarResponse()