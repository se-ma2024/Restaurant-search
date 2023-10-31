package com.example.restaurantsearch.data.api

// ApiService.kt
import com.example.restaurantsearch.data.dataSource.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantApi {
    @GET("gourmet/v1/")
    suspend fun searchRestaurants(
        @Query("key") key: String,
        @Query("keyword") keyword: String?,
        @Query("lat") latitude: Double?,
        @Query("lng") longitude: Double?,
        @Query("start") start: Int?,
        @Query("count") count: Int?,
        @Query("format") format: String?,
        @Query("range") range: Int?
    ): Response<ArticleResponse>
}