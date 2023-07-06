package com.myspace.spaceflightnews.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myspace.spaceflightnews.data.Ripository.Repository
import com.myspace.spaceflightnews.data.model.BlogModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val blogLiveData: MutableLiveData<BlogModel> by lazy {
        MutableLiveData<BlogModel>()
    }

    var isLoaded = false

    fun getBlogData() {
        CoroutineScope(Dispatchers.Main).launch {
            val data = repository.getSpaceBlogs()
            blogLiveData.postValue(data)
            isLoaded = true
        }
    }
}