package com.myspace.spaceflightnews.data.Ripository

import com.myspace.spaceflightnews.data.remote.ApiCall
import javax.inject.Inject


class RepositoryImpl @Inject constructor(val apiCall: ApiCall) : Repository {

    override suspend fun getSpaceFlightNews() = apiCall.getSpaceFlightNews()

    override suspend fun getSpaceBlogs() = apiCall.getSpaceBlogs()
}