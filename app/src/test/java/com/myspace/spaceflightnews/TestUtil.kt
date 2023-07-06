package com.myspace.spaceflightnews

import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.data.model.EventModel
import com.myspace.spaceflightnews.data.model.LauncheModel
import com.myspace.spaceflightnews.data.model.ResultModel
import com.myspace.spaceflightnews.data.model.ResultModelX
import com.myspace.spaceflightnews.data.model.SpaceflightNewsModel

class TestUtil {

    companion object {


        fun getDummyBlogObject(): BlogModel {
            val resultModel = ResultModelX(
                events = listOf(),
                featured = true,
                id = 1,
                imageUrl = "https://example.com/image.jpg",
                launches = listOf(),
                newsSite = "Space News",
                publishedAt = "2023-07-06T10:00:00Z",
                summary = "This is a sample blog post.",
                title = "Sample Blog Post",
                updatedAt = "2023-07-06T12:00:00Z",
                url = "https://example.com/blog/sample"
            )

            return BlogModel(
                count = 1,
                next = "",
                previous = "",
                results = listOf(resultModel)
            )

        }

        fun getNewsModelObject(): SpaceflightNewsModel {
            val eventModel = EventModel(
                eventId = 1,
                provider = "Sample Provider"
            )
            val launcheModel = LauncheModel(
                launchId = "ABC123",
                provider = "Sample Provider"
            )

            val resultModel = ResultModel(
                events = listOf(eventModel),
                featured = true,
                id = 1,
                imageUrl = "https://example.com/image.jpg",
                launches = listOf(launcheModel),
                newsSite = "Space News",
                publishedAt = "2023-07-06T10:00:00Z",
                summary = "This is a sample spaceflight news.",
                title = "Sample Spaceflight News",
                updatedAt = "2023-07-06T12:00:00Z",
                url = "https://example.com/news/sample"
            )

            return SpaceflightNewsModel(
                count = 1,
                next = "",
                previous = "",
                results = listOf(resultModel)
            )

        }
    }


}
