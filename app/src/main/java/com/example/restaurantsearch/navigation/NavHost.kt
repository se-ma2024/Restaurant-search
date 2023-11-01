package com.example.restaurantsearch.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.restaurantsearch.screen.DetailScreen.DetaleScreen
import com.example.restaurantsearch.screen.SearchResultScreen.SearchResultScreen
import com.example.restaurantsearch.screen.SearchResultScreen.SearchResultViewModel
import com.example.restaurantsearch.screen.SearchScreen.SearchScreen

@Composable
fun MainNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("start") {
            // ここにホーム画面のComposeコンポーネントを設定
            SearchScreen(navController = navController)
        }
        composable("SearchResult/{searchWord},{selectRange}") { backStackEntry ->
            val searchWord = backStackEntry.arguments?.getString("searchWord") ?: ""
            val selectRange = backStackEntry.arguments?.getInt("selectRange") ?: 3
            val viewModel = viewModel<SearchResultViewModel>() // ViewModel インスタンスを取得
            if (searchWord == "null") {
                // searchWord が "null" の場合の処理
                // 例: デフォルト値を使用して画面遷移
                SearchResultScreen(
                    TextFieldValue(""),
                    selectRange,
                    navController,
                    viewModel
                )
            } else {
                SearchResultScreen(
                    TextFieldValue(searchWord),
                    selectRange,
                    navController,
                    viewModel
                )
            }
        }

        composable("restaurantDetail/{restaurantId}") { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId")
            val articlesState by viewModel<SearchResultViewModel>().articles.collectAsState()
            val selectedRestaurant = articlesState.find { it.restauranId == restaurantId }
            selectedRestaurant?.let { restaurant ->
                DetaleScreen(restaurant)
            }
        }
    }
}