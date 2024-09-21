package com.example.composeintroduction.domain.repository

import com.example.composeintroduction.data.dto.MovieDataDto
import com.example.composeintroduction.data.dto.SearchResultDto

interface RemoteDataRepository {

    suspend fun getMovieData(title: String): MovieDataDto

    suspend fun getSearchResult(search: String): SearchResultDto
}