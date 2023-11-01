package com.example.restaurantsearch.data.api

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PoweredByHotPepperGourmet() {
    val context = LocalContext.current
    val text = "Powered by ホットペッパーグルメ Webサービス"
    val linkText = "ホットペッパーグルメ Webサービス"
    val websiteUrl = "http://webservice.recruit.co.jp/"

    BasicText(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append(text)
                addStringAnnotation(
                    tag = "URL",
                    annotation = websiteUrl,
                    start = text.indexOf(linkText),
                    end = text.indexOf(linkText) + linkText.length
                )
            }
        },
        modifier = Modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://webservice.recruit.co.jp/"))
                context.startActivity(intent)
            }
            .padding(16.dp) // 余白を追加して中央に配置
    )
}

@Preview
@Composable
fun PreviewPoweredByHotPepperGourmet() {
    PoweredByHotPepperGourmet()
}
