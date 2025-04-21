package com.example.demonewsapp.data.api

import com.example.demonewsapp.data.AppConstants
import com.example.demonewsapp.data.entities.NewsResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
   suspend fun getNewsHeadline(
        @Query("country") country :String,
        @Query("apikey")    apiKey:String= AppConstants.API_KEY
    ):Response<NewsResponseData>


}
// https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=d462531301c2442a8dbe956a28b9ac7a
// https://newsapi.org/v2/everything?q=tesla&from=2025-03-17&sortBy=publishedAt&apiKey=d462531301c2442a8dbe956a28b9ac7a