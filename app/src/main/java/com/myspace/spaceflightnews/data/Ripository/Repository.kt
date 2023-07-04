package com.myspace.spaceflightnews.data.Ripository

import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.data.model.SpaceflightNewsModel
import com.myspace.spaceflightnews.data.remote.ApiDetails
import retrofit2.http.GET

interface Repository {
    suspend fun getSpaceFlightNews(): SpaceflightNewsModel

    suspend fun getSpaceBlogs(): BlogModel
}