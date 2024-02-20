package com.example.newsappmvvm.data

data class NewsList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)