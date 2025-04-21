package com.example.demonewsapp.data.entities

data class NewsResponseData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

