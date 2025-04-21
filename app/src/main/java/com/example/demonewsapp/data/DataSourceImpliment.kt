package com.example.demonewsapp.data

import com.example.demonewsapp.data.api.ApiService
import com.example.demonewsapp.data.entities.NewsResponseData
import jakarta.inject.Inject

import retrofit2.Response

class  DataSourceImpliment @Inject constructor(private val apiService: ApiService) : DataSource {

    override suspend  fun getDataSource(country: String): Response<NewsResponseData> {
        return apiService.getNewsHeadline(country)

    }
}