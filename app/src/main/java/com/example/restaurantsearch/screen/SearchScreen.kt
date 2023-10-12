package com.example.restaurantsearch.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsearch.component.SearchBar
import com.example.restaurantsearch.ui.theme.Title

@Composable
fun SearchScreenContent(modifier: Modifier = Modifier) {
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
                text = "application",
                color = Black,
                style = Title
            )
            Spacer(modifier = Modifier.height(30.dp))
            SearchBar { query ->
                android.util.Log.d("SearchBarExample", "検索クエリ: $query")
            }
        }
    }
}


@Preview
@Composable
fun PreviewSearchbarContent() {
    SearchScreenContent()
}