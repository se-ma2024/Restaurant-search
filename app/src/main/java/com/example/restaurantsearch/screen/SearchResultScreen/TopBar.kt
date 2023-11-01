package com.example.restaurantsearch.screen.SearchResultScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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

    var searchWordLabel = searchWord.text
    if (searchWordLabel == "") {
        searchWordLabel = "近くのお店"
    }
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = searchWordLabel,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigate("start") // SearchScreenに画面遷移
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    val navController = rememberNavController()
    val searchWord = "searchWord"
    TopBar(searchWord = TextFieldValue(searchWord), navController)
}