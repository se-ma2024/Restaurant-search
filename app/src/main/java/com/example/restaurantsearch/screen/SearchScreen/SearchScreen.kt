package com.example.restaurantsearch.screen.SearchScreen

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsearch.R
import com.example.restaurantsearch.ui.theme.Label
import com.example.restaurantsearch.ui.theme.Title

@Composable
fun SearchScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    var searchWord by remember { mutableStateOf("") }
    var selectRange by remember { mutableStateOf(3) }
    val genres = listOf("イタリア料理", "寿司・和食", "中華料理", "フレンチ", "居酒屋", "ラーメン")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.application_name),
                color = Black,
                style = Title
            )
            Spacer(modifier = Modifier.height(30.dp))
            SearchBar(navController = navController, selectRange = selectRange) { text ->
                searchWord = text
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "検索範囲",
                    color = Black,
                    style = Label,
                )
                SelectRange(selectRange) { range ->
                    selectRange = range
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(genres) { genre ->
                    GenreButton(
                        navController = navController,
                        selectRange = selectRange,
                        genre = genre
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    val navController: NavHostController = rememberNavController()
    SearchScreen(navController = navController)
}