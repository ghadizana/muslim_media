package com.ghadiza.muslimmediaapp.model.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// declaration the method for controlling data that we want
interface ApiService {

    @GET("/v2/everything")
    fun getCommonMuslimNews(
        @Query("q") q: String = "islam",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 15,
        @Query("sortBy") sortBy: String = "popularity"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getAlQuranNews(
        @Query("q") q: String = "al-quran",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>

    @GET("/b2/everything")
    fun getAlJazeeraNews(
        @Query("source") source: String = "al-jazeera-english"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getWarningForMuslimNews(
        @Query("q") q: String = "anti islam",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getSearchNews(
        @Query("q") q: String,
        @Query("pageSize") pageSize: Int = 19
    ): Call<NewsResponse>
}