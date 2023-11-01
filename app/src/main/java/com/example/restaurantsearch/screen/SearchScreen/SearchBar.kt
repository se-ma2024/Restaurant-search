package com.example.restaurantsearch.screen.SearchScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(navController: NavHostController, selectRange: Int, onSearch: (String) -> Unit) {

    var searchWord by remember { mutableStateOf("") }
    var selectRange = selectRange

    TopAppBar(
        modifier = Modifier
            .background(Color.Transparent)
            .zIndex(1f), // 影を持たせる
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = searchWord,
                    onValueChange = {
                        searchWord = it
                    },
                    placeholder = { Text("検索...") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search//エンターキーを検索アクションにマップ
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Sharp.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Sharp.Close,
                            contentDescription = "×",
                            modifier = Modifier.clickable { // クリックハンドラを設定
                                searchWord = "" // テキストをクリア
                            }
                        )
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            if (searchWord.isNotBlank()) {
                                onSearch(searchWord)
                                navController.navigate("SearchResult/${searchWord},${selectRange}")
                            } else {
                                navController.navigate("SearchResult/null,${selectRange}")
                            }
                        }
                    )
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    )
}

@Preview
@Composable
fun PreviewSerchBar() {
    val navController = rememberNavController()
    val selectRange = 3
    SearchBar(navController = navController, selectRange) { query ->
        Log.d("SearchBarExample", "検索クエリ: $query")
    }
}