package com.example.composeintroduction.presentation.detail_sc.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintroduction.util.MySpacer

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    movieTitle: String,
    errorMsg: String
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.ErrorOutline,
                contentDescription = null,
            )
            MySpacer(size = 16.dp)
            Text(
                text = "Movie: $movieTitle",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)

            )
            MySpacer(size = 16.dp)
            Text(
                text = errorMsg,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
                modifier = modifier
                    .padding(horizontal = 16.dp)

            )
        }

    }
}