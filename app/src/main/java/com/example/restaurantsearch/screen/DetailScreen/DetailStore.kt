package com.example.restaurantsearch.screen.DetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restaurantsearch.ui.theme.Information
import com.example.restaurantsearch.ui.theme.Label
import com.example.restaurantsearch.ui.theme.SubLabel

@Composable
fun DetailStore() {
    val BusinessHours = "月～金／11：30～14：00"
    val RegularHoliday = "日"
    val Address = "東京都中央区銀座８－４－１７"
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(12.dp)
    ) {
        Row() {
            Text(
                text = "店舗情報",
                style = Label
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "営業時間",
                style = SubLabel
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = BusinessHours,
                style = Information
            )
        }
        Row() {
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "定休日",
                style = SubLabel
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = RegularHoliday,
                style = Information
            )
        }
        Row() {
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "住所",
                style = SubLabel
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = Address,
                style = Information
            )
        }
    }
}

@Preview
@Composable
fun PreviewDetailStore() {
    DetailStore()
}