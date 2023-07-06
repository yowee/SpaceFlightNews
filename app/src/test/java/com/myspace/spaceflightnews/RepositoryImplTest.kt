package com.myspace.spaceflightnews

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.myspace.spaceflightnews.data.Ripository.Repository
import com.myspace.spaceflightnews.data.Ripository.RepositoryImpl
import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.data.remote.ApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    lateinit var blogModel: BlogModel
    lateinit var repository: Repository

    // allow me to use the threads
    private val testDispatcher = StandardTestDispatcher()

    // allow me to run tasks on threads with priority
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiCall: ApiCall


    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        repository = RepositoryImpl(apiCall)
    }

    @Test
    fun verify_getSpace_flight_news() = runTest {
        `when`(apiCall.getSpaceFlightNews()).thenReturn(TestUtil.getNewsModelObject())
        val actualNewsModel = repository.getSpaceFlightNews()
        assertEquals(TestUtil.getNewsModelObject(), actualNewsModel)
    }

    @Test
    fun `getSpaceBlogs should return expected blog details`() = runTest {
        val expectedBlogModel = TestUtil.getDummyBlogObject()
        `when`(apiCall.getSpaceBlogs()).thenReturn(expectedBlogModel)

        val actualBlogModel = repository.getSpaceBlogs()

        assertEquals(expectedBlogModel.results[0].summary, actualBlogModel.results[0].summary)
        assertEquals(expectedBlogModel.count, actualBlogModel.count)
        assertEquals(expectedBlogModel.previous, actualBlogModel.previous)
    }

    @Test
    fun verify_getSpaceBlogs_returnsNonNullResults() = runTest {
        val expectedBlogModel = TestUtil.getDummyBlogObject()
        `when`(apiCall.getSpaceBlogs()).thenReturn(expectedBlogModel)

        val actualBlogModel = repository.getSpaceBlogs()

        assertNotNull(actualBlogModel.results)
        assertFalse(actualBlogModel.results.isEmpty())
    }

    @Test
    fun verify_getSpaceFlightNews_returnsNonNullResults() = runTest {
        val expectedNewsModel = TestUtil.getNewsModelObject()
        `when`(apiCall.getSpaceFlightNews()).thenReturn(expectedNewsModel)

        val actualNewsModel = repository.getSpaceFlightNews()

        assertNotNull(actualNewsModel.results)
        assertFalse(actualNewsModel.results.isEmpty())
    }


    @Test
    fun verify_getSpaceBlogs_returnsExpectedBlogTitle() = runTest {
        val expectedBlogModel = TestUtil.getDummyBlogObject()
        `when`(apiCall.getSpaceBlogs()).thenReturn(expectedBlogModel)
        val expectedTitle = expectedBlogModel.results[0].title

        val actualBlogModel = repository.getSpaceBlogs()
        val actualTitle = actualBlogModel.results[0].title

        assertEquals(expectedTitle, actualTitle)
    }



}









