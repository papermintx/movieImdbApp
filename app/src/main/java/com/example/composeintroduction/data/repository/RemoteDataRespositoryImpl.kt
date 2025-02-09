package com.example.composeintroduction.data.repository

import com.example.composeintroduction.data.MovieApi
import com.example.composeintroduction.data.dto.MovieDataDto
import com.example.composeintroduction.data.dto.SearchResultDto
import com.example.composeintroduction.domain.repository.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataRespositoryImpl @Inject constructor(
    private val api: MovieApi
):RemoteDataRepository{
    override suspend fun getMovieData(title: String): MovieDataDto {
        return withContext(Dispatchers.Default){
            api.getMovieData(title = title)
        }
    }

    override suspend fun getSearchResult(search: String): SearchResultDto {
        return withContext(Dispatchers.Default){
            api.getSearchResult(search = search)
        }
    }
}