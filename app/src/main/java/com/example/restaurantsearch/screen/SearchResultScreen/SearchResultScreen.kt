package com.example.restaurantsearch.screen.SearchResultScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//import com.example.restaurantsearch.data.api.RestaurantApiClient
//import com.example.restaurantsearch.data.api.RestaurantApiClient.API_KEY

@Composable
fun SearchResultScreen(
    searchWord: TextFieldValue,
    selectRange: Int,
    navController: NavHostController,
    viewModel: SearchResultViewModel
) {
    //RestaurantApiClient.create()

    //var searchResults by remember { mutableStateOf<List<Article>>(emptyList()) }

    //val searchResults by viewModel.searchResults.collectAsState()

    //val viewModel = SearchResultViewModel()

    //val BASE_URL = "https://webservice.recruit.co.jp/hotpepper/"
    val API_KEY = "79e2666acd1d3353"

    val articles by viewModel.articles.collectAsState()

// API通信を実行

    val latitude = 34.67
    val longitude = 135.52
    val start: Int = 1
    val count: Int = 100
    val format: String = "json"

    viewModel.fetchArticles(
        key = API_KEY,
        keyword = searchWord.text,
        latitude = latitude,
        longitude = longitude,
        start = start,
        count = count,
        format = format,
        range = selectRange
    )

    //val restaurantData = viewModel.restaurantData.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Column() {
            TopBar(searchWord, navController = navController)
            LazyColumn {
                items(articles) { article ->
                    SearchResultCard(article)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearchResultScreen() {
    val navController = rememberNavController()
    val searchWord = "検索Word"
    val selectRange = 2
    val viewModel = viewModel<SearchResultViewModel>() // ViewModel インスタンスを取得
    SearchResultScreen(
        searchWord = TextFieldValue(searchWord),
        selectRange = selectRange,
        navController = navController,
        viewModel = viewModel
    )
}