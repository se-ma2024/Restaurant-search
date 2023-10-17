package com.example.restaurantsearch.data.api.reaponse

import kotlinx.serialization.Serializable

@Serializable
data class ArticleListResponse(
    val articles: List<Article>
)

@Serializable
data class Detail(
    val RestauranName: String,
    val TopImage: String,
    val Catch: String,
    val BusinessHours: String,
    val RegularHoliday: String,
    val Address: String
)

@Serializable
data class Article(
    val RestauranName: String,
    val thumbnailImageURL: String,
    val Catch: String,
    val BusinessHours: String
)

@Serializable
data class Contributor(
    val id: String,
    val nickname: String,
    val introduction: String,
    val imageURL: String
)