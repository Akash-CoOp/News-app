package com.example.demonewsapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demonewsapp.data.AppConstants
import com.example.demonewsapp.data.entities.NewsResponseData
import com.example.demonewsapp.ui.repository.NewsRepository
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
    //idhr hilt kaam aara kyuki newsrepo kobhout cheeje chahiye isliye hilt kaam aata idhar


): ViewModel(){


    private val newsState: MutableStateFlow<ResourceState<NewsResponseData>> = MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponseData>> = newsState

    init {
        getNews(AppConstants.FIRST_COUNTRY  )

    }


    fun getNews(country:String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadlines(country).collectLatest {
                newsResponse->
                newsState.value = newsResponse


            }
        }

    }

}