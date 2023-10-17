package com.example.restaurantsearch.screen.SearchResultScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchResultScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Column() {
            TopBar(navController = navController)
            LazyColumn {
                items(10) { index ->
                    SearchResultCard()
                }
            }
        }
    }


}


@Preview
@Composable
fun PreviewSearchResultScreen() {
    val navController = rememberNavController()
    SearchResultScreen(navController = navController)
}