package com.example.restaurantsearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.restaurantsearch.R

@Composable
fun DetailImage() {
    val TopImage = ""//画像のURLを入れる
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth() // 画面幅いっぱいに拡大
            .aspectRatio(1f) // 縦横比率を1:1に維持
    )
}

@Preview
@Composable
fun PreviewDetailImage() {
    DetailImage()
}

