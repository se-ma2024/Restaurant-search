package com.example.restaurantsearch.screen.DetailScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restaurantsearch.data.dataSource.Article

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetaleScreen(restaurant: Article) {
    val navController: NavHostController = rememberNavController()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        stickyHeader {
            // このセクション内のコンポーネントはスクロールせずに固定されます
            DetailTopBar(restaurantName = restaurant.restaurantName, navController = navController)
        }
        item {
            //DetailTopBar(navController = navController)
            //Spacer(modifier = Modifier.height(64.dp))
            DetailImage()
            Spacer(modifier = Modifier.height(4.dp))
            DetailCatchphrase()
            Spacer(modifier = Modifier.height(4.dp))
            DetailStore()
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDetaleScreen() {
    val dummyArticle = Article(
        restauranId = "J003340731",
        restaurantName = "中華そば 福笑門",
        thumbnailImageURL = "https://imgfp.hotp.jp/SYS/cmn/images/common/diary/custom/m30_img_noimage.gif",
        catch = "一度食べたらハマるラーメン",
        businessHours = "月～土、祝日、祝前日: 11:00～15:00、17:00～22:00",
        access = "布施駅から徒歩2分"
        // 他の詳細情報を追加
    )

    DetaleScreen(restaurant = dummyArticle)
}