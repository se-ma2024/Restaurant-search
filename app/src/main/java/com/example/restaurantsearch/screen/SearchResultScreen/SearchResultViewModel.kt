package com.example.restaurantsearch.screen.SearchResultScreen

//import com.example.restaurantsearch.data.api.RestaurantRepository
//import com.example.restaurantsearch.data.dataSource.Article
//import com.example.restaurantsearch.data.api.RestaurantApiClient
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantsearch.data.api.WikiRepository
import com.example.restaurantsearch.data.api.WikiRepositoryImpl
import com.example.restaurantsearch.data.dataSource.Article
import com.example.restaurantsearch.data.dataSource.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SearchResultViewModel(private val repository: WikiRepository = WikiRepositoryImpl()) :
    ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    fun fetchArticles(
        key: String,
        keyword: String,
        latitude: Double,
        longitude: Double,
        start: Int,
        count: Int,
        format: String,
        range: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.getArticles(
                    key,
                    keyword,
                    latitude,
                    longitude,
                    start,
                    count,
                    format,
                    range
                )
            }.onSuccess { response ->
                // データ取得成功時
                if (response != null) postArticles(response)
            }.onFailure {
                // データ取得失敗時
                Log.e("Fetch Failure", it.toString())
                Log.d("API Response", it.toString())
            }
        }
    }

    private fun postArticles(response: ArticleResponse) {
        _articles.value = response.results.shops?.map { response ->
            Article(
                restauranId = response.id,
                restauranName = response.name,
                thumbnailImageURL = response.logoImage,
                catch = response.catchPhrase,
                businessHours = response.open
            )
        } ?: emptyList()
    }
}
