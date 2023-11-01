package com.example.restaurantsearch.screen.SearchResultScreen

//import com.example.restaurantsearch.data.dataSource.Article
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.restaurantsearch.data.dataSource.Article
import com.example.restaurantsearch.ui.theme.Explanation
import com.example.restaurantsearch.ui.theme.Label

@Composable
fun SearchResultCard(article: Article, navController: NavHostController) {
    val restauranId = article.restauranId
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            //.height(132.dp)
            .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
            .background(color = Color.White)
            .clickable {
                navController.navigate("restaurantDetail/${restauranId}")
            },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Image(
                //painter = painter,
                //painterResource(id = R.drawable.ic_launcher_background),
                painter = rememberImagePainter(article.thumbnailImageURL), // 画像のURLを指定
                contentDescription = null,
                modifier = Modifier
                    .width(144.dp) // 幅を指定
                    .height(144.dp) // 高さを指定
                    .background(color = Color.DarkGray)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column() {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = article.restaurantName ?: "店舗名情報なし",
                    style = Label,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = article.catch ?: "店舗情報なし",
                        style = Explanation,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = article.access ?: "アクセス情報なし",
                        style = Explanation,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearchResultCard() {
    val navController = rememberNavController()
    val articles = List(10) {
        Article(
            restauranId = "J001128449",
            restaurantName = "麺FACTORY JAWS おいしいラーメン屋さん",
            thumbnailImageURL = "https://imgfp.hotp.jp/IMGH/43/92/P022794392/P022794392_69.jpg",
            catch = "上本町のラーメン店！上本町のラーメン店！上本町のラーメン店！上本町のラーメン店！",
            businessHours = "火～日、祝日、祝前日: 11:00～15:00、18:00～23:00、月: 休業",
            access = "布施駅から徒歩2分"
        )
    }

    LazyColumn(modifier = Modifier.background(color = Color.LightGray)) {
        items(articles) { article ->
            SearchResultCard(article = article, navController = navController)
        }
    }
}