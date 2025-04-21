package com.example.demonewsapp.data

import com.example.demonewsapp.data.entities.NewsResponseData
import retrofit2.Response

interface DataSource
    {
       suspend fun getDataSource(country:String): Response<NewsResponseData>

}