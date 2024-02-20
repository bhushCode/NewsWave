package com.example.newsappmvvm.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsappmvvm.data.Article
import com.example.newsappmvvm.data.NewsList
import com.example.newsappmvvm.retrofit.NewsApi
import com.example.newsappmvvm.utils.NetworkUtils

class NewsRepository(private  val newsApi: NewsApi,private  val category:String,private val applicationContext:Context) {

    private  val newsLiveData = MutableLiveData<NewsList>()

    val news:LiveData<NewsList>
        get() = newsLiveData


    suspend fun getNews() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {


            var result = newsApi.getNews("in", "technology", 30, "your_api_key")
            if (category.equals("sports"))
                result = newsApi.getNews("in", "sports", 30, "your_api_key")
            if (category.equals("business"))
                result = newsApi.getNews("in", "business", 30, "your_api_key")
            if (category.equals("entertainment"))
                result =
                    newsApi.getNews("in", "entertainment", 30, "your_api_key")
            if (category.equals("general"))
                result = newsApi.getNews("in", "general", 30, "your_api_key")
            if (category.equals("science"))
                result = newsApi.getNews("in", "science", 30, "your_api_key")
            if (category.equals("health"))
                result = newsApi.getNews("in", "health", 30, "your_api_key")
            if (category.equals("technology"))
                result = newsApi.getNews("in", "technology", 30, "your_api_key")




            if (result != null && result.body() != null) {
                newsLiveData.postValue(result.body())
            }
        }

    }



}
