package com.example.restaurantsearch.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsearch.ui.theme.Label

@Composable
fun DetailCatchphrase() {
    val Catchphrase: String = "TVの口コミランキングで堂々1位に輝いた一口餃子専門店！！"
    Text(
        text = Catchphrase,
        maxLines = 10,
        style = Label,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    )
}

@Preview
@Composable
fun PreviewDetailCatchphrase() {
    DetailCatchphrase()
}