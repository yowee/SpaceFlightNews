package com.myspace.spaceflightnews.data.remote


import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.data.model.SpaceflightNewsModel
import retrofit2.http.GET


interface ApiCall {

    @GET(ApiDetails.END_POINT)
    suspend fun getSpaceFlightNews(): SpaceflightNewsModel

    @GET(ApiDetails.BLOG_END_POINT)
    suspend fun getSpaceBlogs(): BlogModel
}