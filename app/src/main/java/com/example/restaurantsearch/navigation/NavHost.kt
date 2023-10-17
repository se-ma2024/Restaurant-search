package com.example.restaurantsearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.restaurantsearch.screen.DetailScreen.DetaleScreen
import com.example.restaurantsearch.screen.SearchResultScreen.SearchResultScreen
import com.example.restaurantsearch.screen.SearchScreen.SearchScreenContent

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "start"
    ) {
        composable("start") {
            // ここにホーム画面のComposeコンポーネントを設定
            SearchScreenContent(navController = navController)
        }
        composable("SearchResult") {
            SearchResultScreen(navController = navController)
        }
        composable("Detail") {
            DetaleScreen()
        }

    }
}