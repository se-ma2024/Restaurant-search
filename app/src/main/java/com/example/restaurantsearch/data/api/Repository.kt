package com.example.restaurantsearch.data.api

import com.example.restaurantsearch.data.dataSource.ArticleResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
interface WikiRepository {
    suspend fun getArticles(
        key: String,
        keyword: String,
        latitude: Double,
        longitude: Double,
        start: Int,
        count: Int,
        format: String,
        range: Int
    ): ArticleResponse?
}

class WikiRepositoryImpl : WikiRepository {
    // JSONからKotlinのクラスに変換するためのライブラリの設定
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // REST APIを利用するためのライブラリの設定
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://webservice.recruit.co.jp/hotpepper/") // 今回利用するWeb APIのURL
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(createOkHttpClient())
        .build()

    // WikiApiClientに定義したメソッドを呼び出すための設定
    private val wikiService = retrofit.create(RestaurantApi::class.java)

    // Web APIからデータを取得するメソッド
    override suspend fun getArticles(
        key: String,
        keyword: String,
        latitude: Double,
        longitude: Double,
        start: Int,
        count: Int,
        format: String,
        range: Int
    ): ArticleResponse? {
        return wikiService.searchRestaurants(
            key,
            keyword,
            latitude,
            longitude,
            start,
            count,
            format,
            range
        ).body()
    }
    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}