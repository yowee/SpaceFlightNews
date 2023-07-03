package com.myspace.spaceflightnews.data.model


import com.google.gson.annotations.SerializedName

data class BlogModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<ResultModelX>
)