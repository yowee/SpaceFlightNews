package com.myspace.spaceflightnews.data.model


import com.google.gson.annotations.SerializedName

data class ResultModelX(
    @SerializedName("events")
    val events: List<Any>,
    @SerializedName("featured")
    val featured: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("launches")
    val launches: List<Any>,
    @SerializedName("news_site")
    val newsSite: String,
    @SerializedName("published_at")
    val publishedAt: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)