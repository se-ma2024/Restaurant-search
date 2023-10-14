package com.example.restaurantsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsearch.R
import com.example.restaurantsearch.ui.theme.Explanation
import com.example.restaurantsearch.ui.theme.Information
import com.example.restaurantsearch.ui.theme.Label

@Composable
fun SearchResultCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(start = 12.dp, top = 4.dp, end = 12.dp, bottom = 4.dp)
            .background(color = Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "居酒屋 ホットペッパー",
                    style = Label,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(end = 16.dp)) {
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column() {
                    Text(
                        text = "TVの口コミランキングで堂々1位に輝いた一口餃子専門店！！",
                        style = Explanation,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.BusinessHours),
                        style = Information

                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "月～金／11：30～14：00"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearchResultCard() {
    SearchResultCard()
}