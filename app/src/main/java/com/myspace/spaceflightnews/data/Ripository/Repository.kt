package com.myspace.spaceflightnews.data.Ripository

import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.data.model.SpaceflightNewsModel

interface Repository {
    suspend fun getSpaceFlightNews(): SpaceflightNewsModel

    suspend fun getSpaceBlogs(): BlogModel
}