package com.example.composeintroduction.presentation.search_sc.composents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintroduction.domain.model.SearchResult


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    searchResult: SearchResult,
    onClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Text(
                text = "Search Result",
                fontFamily = FontFamily.Monospace,
                modifier = modifier
                    .basicMarquee()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }

        items(
            searchResult.movies
        ){ movie ->
            Card(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = movie.title,
                        modifier  = modifier
                            .padding(start = 8.dp)
                            .weight(8f)
                            .basicMarquee(),
                        fontSize = 18.sp
                        , fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )

                    IconButton(
                        onClick = {
                            onClick(movie.title)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                            contentDescription = null,
                            modifier = modifier
                                .weight(2f)
                        )
                    }

                }

            }
        }

    }
}