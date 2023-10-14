package com.example.restaurantsearch.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsearch.component.SearchResultCard
import com.example.restaurantsearch.component.TopBar

@Composable
fun SearchResultScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        Column() {
            val navController: NavHostController = rememberNavController()
            TopBar(navController = navController)
            Spacer(modifier = Modifier.height(8.dp))
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
    SearchResultScreen()
}