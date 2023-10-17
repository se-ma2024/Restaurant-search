package com.example.restaurantsearch.screen.DetailScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetaleScreen() {
    val navController: NavHostController = rememberNavController()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        stickyHeader {
            // このセクション内のコンポーネントはスクロールせずに固定されます
            DetailTopBar(navController = navController)
        }
        item {
            //DetailTopBar(navController = navController)
            //Spacer(modifier = Modifier.height(64.dp))
            DetailImage()
            Spacer(modifier = Modifier.height(4.dp))
            DetailCatchphrase()
            Spacer(modifier = Modifier.height(4.dp))
            DetailStore()
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDetaleScreen() {
    //val navController:NavHostController = rememberNavController()
    DetaleScreen()
}