package com.example.restaurantsearch.screen.SearchResultScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.restaurantsearch.R
import com.example.restaurantsearch.data.api.PoweredByHotPepperGourmet
import com.example.restaurantsearch.ui.theme.CountLabel

@Composable
fun SearchResultScreen(
    searchWord: TextFieldValue,
    selectRange: Int,
    navController: NavHostController,
    viewModel: SearchResultViewModel
) {
    val API_KEY = stringResource(R.string.api_key)

    val articles by viewModel.articles.collectAsState()

    val dataCount = articles.size

    //val mainViewModel = viewModel<MainViewModel>()
    // MainViewModelから緯度と経度のLiveDataを取得
    //val latitude: Double by mainViewModel.latitude.observeAsState(0.0)
    //val longitude: Double by mainViewModel.longitude.observeAsState(0.0)
    val latitude = 34.705647748772236
    val longitude = 135.49483743011916
    val start = 1
    val count = 100
    val format = "json"

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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Column() {
            TopBar(searchWord, navController = navController)
            Spacer(modifier = Modifier.height(4.dp))
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                    ) {
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "${dataCount}件",
                            style = CountLabel
                        )
                    }
                }
                items(articles) { article ->
                    SearchResultCard(article = article, navController = navController)
                }
                item {
                    Spacer(modifier = Modifier.height(60.dp)) // スペースの高さを調整
                }
                item {
                    PoweredByHotPepperGourmet()
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