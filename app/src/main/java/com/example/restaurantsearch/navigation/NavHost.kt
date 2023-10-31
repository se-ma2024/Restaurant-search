package com.example.restaurantsearch.navigation

import androidx.compose.runtime.Composable
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
            val selectRange = backStackEntry.arguments?.getInt("selectRange") ?: 0
            val viewModel = viewModel<SearchResultViewModel>() // ViewModel インスタンスを取得
            SearchResultScreen(TextFieldValue(searchWord), selectRange, navController, viewModel)
        }

        composable("Detail") {
            DetaleScreen()
        }

    }
}