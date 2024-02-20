package com.example.newsappmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappmvvm.data.Article
import com.example.newsappmvvm.data.NewsList
import com.example.newsappmvvm.repository.NewsRepository
import kotlinx.coroutines.launch

class MainViewModel(private val newsRepository: NewsRepository):ViewModel() {

    init {
        viewModelScope.launch {
            newsRepository.getNews()
        }
    }


    val news:LiveData<NewsList>
        get() = newsRepository.news


}