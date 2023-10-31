package com.example.restaurantsearch.screen.SearchResultScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(searchWord: TextFieldValue, navController: NavHostController) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = searchWord.text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    //navController.popBackStack() // 前の画面に戻るアクション
                    navController.navigate("start") // SearchScreenに画面遷移
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        },
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    val navController = rememberNavController()
    val searchWord = "searchWord"
    TopBar(searchWord = TextFieldValue(searchWord), navController)
}