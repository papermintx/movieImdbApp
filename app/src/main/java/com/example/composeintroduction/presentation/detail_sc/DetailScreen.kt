package com.example.composeintroduction.presentation.detail_sc

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalMovies
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeintroduction.presentation.MainViewModel
import com.example.composeintroduction.presentation.detail_sc.components.ErrorScreen
import com.example.composeintroduction.presentation.detail_sc.components.LoadingScreen
import com.example.composeintroduction.presentation.detail_sc.components.MovieData
import com.example.composeintroduction.util.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    title: String,
    viewmodel: MainViewModel = hiltViewModel()
) {
    LaunchedEffect(
        key1 = true ,
        block = {
            viewmodel.getMovieData(title)
        }
    )

    val movieDataResponse = viewmodel.movieDataResponse.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movie Database",
                        fontFamily = FontFamily.Serif,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.LocalMovies,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {paddingValues ->
        AnimatedContent(
            targetState = movieDataResponse,
            label = "Animated Content",
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues),
            transitionSpec = {
                fadeIn(animationSpec = tween(300, easing = LinearEasing))togetherWith fadeOut(
                    animationSpec = tween(300, easing = LinearEasing
                ))
            }

        ) {responseMovie ->
            when(responseMovie){
                is Result.Success -> {
                   val movieData = responseMovie.data
                   MovieData(
                       movieData = movieData
                   )
                }
                is Result.Loading -> {
                    LoadingScreen()
                }
                is Result.Error -> {
                    ErrorScreen(
                        movieTitle = title,
                        errorMsg = responseMovie.exception.message ?: "Unknown error"
                    )
                }
                else -> Unit
            }
        }
    }

}