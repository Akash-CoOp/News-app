package com.example.demonewsapp.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demonewsapp.ui.components.Loader
import com.example.demonewsapp.ui.components.NewsRowComponent

import com.example.demonewsapp.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState


@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse = newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) {
        100
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 9.dp
    ) { page :Int->

            when (val response = newsResponse.value) {
                is ResourceState.Loading -> {
                    Log.d("loading", "loading hora")
                    Loader()
                }

                is ResourceState.Error -> {
                    Log.d("Error", "Error hora")
                    val errorMessage = response.error
                    Log.d("Error", "$errorMessage")
                }

                is ResourceState.Success -> {
                    Log.d("success", "success hora")
                    val responseData = response.data
                    Log.d("success", "${responseData.totalResults}")
                    if (responseData.articles.isNotEmpty()) {
                        NewsRowComponent(page, responseData.articles[page])
                    }

                }
            }

    }
}


