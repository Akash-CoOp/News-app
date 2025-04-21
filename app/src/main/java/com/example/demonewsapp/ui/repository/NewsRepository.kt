package com.example.demonewsapp.ui.repository

import com.example.demonewsapp.data.DataSource
import com.example.demonewsapp.data.entities.NewsResponseData
import com.example.utilities.ResourceState
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class NewsRepository @Inject constructor(
    private val dataSource: DataSource
){
//    suspend fun getNewsHeadlines(country : String): Response<NewsResponseData>{
//        return  dataSource.getDataSource(country)
//
//    }
    suspend fun getNewsHeadlines(country : String):Flow<ResourceState<NewsResponseData>> {
        return flow {
            emit(ResourceState.Loading())
           val response=  dataSource.getDataSource(country)
           if( response.isSuccessful && response.body() != null)
               emit(ResourceState.Success(response.body()!!))
            else{
                emit(ResourceState.Error("Error fetching news data"))

           }

        }.catch { e->
            emit(ResourceState.Error(e.localizedMessage))
        }
    }
}