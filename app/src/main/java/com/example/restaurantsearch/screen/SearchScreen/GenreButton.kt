package com.example.restaurantsearch.screen.SearchScreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsearch.ui.theme.SubLabel

@Composable
fun GenreButton(navController: NavHostController, selectRange: Int, genre: String) {
    val searchWord = genre
    var selectRange = selectRange
    Button(
        onClick = { navController.navigate("SearchResult/${searchWord},${selectRange}") },
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .padding(8.dp)
    ) {
        Text(
            text = genre,
            style = SubLabel
        )
    }
}

@Preview
@Composable
fun PreviewGenreButton() {
    val navController: NavHostController = rememberNavController()
    val wa = "ラーメン"
    val selectRange = 3
    GenreButton(navController = navController, selectRange = selectRange, genre = wa)
}
