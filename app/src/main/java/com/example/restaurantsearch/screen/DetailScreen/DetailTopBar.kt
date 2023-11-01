package com.example.restaurantsearch.screen.DetailScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(restaurantName: String?, navController: NavController) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = restaurantName ?: "", maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() } // 前の画面に戻るアクション
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
    )
}

@Preview
@Composable
fun PreviewDetailTopBar() {
    val navController = rememberNavController()
    val restaurantName = "ラーメン屋さんですお"
    DetailTopBar(restaurantName, navController)
}