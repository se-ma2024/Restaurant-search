package com.example.restaurantsearch.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue()) }

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
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    placeholder = { Text("検索...") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search//エンターキーを検索アクションにマップ
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onSearch(text.text)
                        }
                    )
                )
                Button(
                    onClick = {
                        onSearch(text.text)
                    }
                ) {
                    Text(text = "決定")
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewSerchBar() {
    SearchBar { query ->
        android.util.Log.d("SearchBarExample", "検索クエリ: $query")
    }
}