package com.example.restaurantsearch.screen.SearchResultScreen

//import com.example.restaurantsearch.data.dataSource.Article
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.restaurantsearch.R
import com.example.restaurantsearch.data.dataSource.Article
import com.example.restaurantsearch.ui.theme.Explanation
import com.example.restaurantsearch.ui.theme.Information
import com.example.restaurantsearch.ui.theme.Label

@Composable
fun SearchResultCard(article: Article) {
    val painter = article.thumbnailImageURL
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
                    text = article.restauranName ?: "情報なし",
                    style = Label,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.padding(end = 16.dp)) {
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    //painter = painter,
                    //painterResource(id = R.drawable.ic_launcher_background),
                    painter = rememberImagePainter(article.thumbnailImageURL),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp) // 幅を指定
                        .height(100.dp) // 高さを指定
                        .background(color = Color.LightGray)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column() {
                    Text(
                        text = article.catch ?: "情報なし",
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
                            text = article.businessHours ?: "情報なし"
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
    val article = Article(
        restauranId = "123",
        restauranName = "サンプルレストラン",
        thumbnailImageURL = "https://example.com/sample_image.jpg", // 仮の画像のURL
        catch = "レストランのキャッチフレーズのサンプルです。これはカードで切り詰められる長いキャッチフレーズです。",
        businessHours = "月曜日から金曜日：10時 - 20時"
    )

    SearchResultCard(article = article)
}