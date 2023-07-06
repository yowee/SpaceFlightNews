package com.myspace.spaceflightnews.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myspace.spaceflightnews.data.Ripository.Repository
import com.myspace.spaceflightnews.data.model.SpaceflightNewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val articleLiveData: MutableLiveData<SpaceflightNewsModel> by lazy {
        MutableLiveData<SpaceflightNewsModel>()
    }
    var isLoaded = false
    fun getArticleData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.getSpaceFlightNews()
            articleLiveData.postValue(result)
            isLoaded = true
        }
    }
}