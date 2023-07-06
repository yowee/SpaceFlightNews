package com.myspace.spaceflightnews

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.myspace.spaceflightnews.data.Ripository.Repository
import com.myspace.spaceflightnews.data.model.BlogModel
import com.myspace.spaceflightnews.ui.ArticleViewModel
import com.myspace.spaceflightnews.ui.BlogViewModel
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ArticleViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val standardDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: ArticleViewModel


    @Mock
    lateinit var repository: Repository

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(dispatcher = standardDispatcher)
        viewModel = ArticleViewModel(repository)
    }

    @Test
    fun verify_get_blog_data() = runTest {
        Mockito.`when`(repository.getSpaceFlightNews()).thenReturn(TestUtil.getNewsModelObject())
        viewModel.getArticleData()
        standardDispatcher.scheduler.advanceUntilIdle()
        TestCase.assertEquals(
            viewModel.articleLiveData.value?.results?.size,
            TestUtil.getDummyBlogObject().results.size
        )
        TestCase.assertEquals(
            viewModel.articleLiveData.value?.results?.get(0)?.imageUrl,
            TestUtil.getDummyBlogObject().results.get(0).imageUrl
        )
    }

}