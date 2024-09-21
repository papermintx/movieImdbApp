package com.example.composeintroduction.domain.model

import com.example.composeintroduction.data.dto.Movie


data class SearchResult(
    val movies: List<Movie>
)