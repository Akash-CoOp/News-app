package com.example.demonewsapp.data.entities

data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)