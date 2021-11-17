package com.watermelon.moviesapp.model.response

import com.google.gson.annotations.SerializedName
import com.watermelon.moviesapp.model.response.Movies

open class BaseSimilarResponse (
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)