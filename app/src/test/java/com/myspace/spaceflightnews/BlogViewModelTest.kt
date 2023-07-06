package com.myspace.spaceflightnews

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.myspace.spaceflightnews.data.Ripository.Repository
import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.ui.BlogViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class BlogViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val standardDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: BlogViewModel

    @Mock
    lateinit var observer: Observer<BlogModel>

    @Mock
    lateinit var repository: Repository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(dispatcher = standardDispatcher)
        viewModel = BlogViewModel(repository)
    }

    @Test
    fun verify_get_blog_data() = runTest {
        Mockito.`when`(repository.getSpaceBlogs()).thenReturn(TestUtil.getDummyBlogObject())
        viewModel.getBlogData()
        standardDispatcher.scheduler.advanceUntilIdle()
        assertEquals(
            viewModel.blogLiveData.value?.results?.size,
            TestUtil.getDummyBlogObject().results.size
        )
        assertEquals(
            viewModel.blogLiveData.value?.results?.get(0)?.imageUrl,
            TestUtil.getDummyBlogObject().results.get(0).imageUrl
        )
    }


}