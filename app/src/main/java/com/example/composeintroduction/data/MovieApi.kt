package com.example.composeintroduction.data

import com.example.composeintroduction.data.dto.MovieDataDto
import com.example.composeintroduction.data.dto.SearchResultDto
import com.example.composeintroduction.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApi {

    @GET("/")
    suspend fun getMovieData(
        @Query("apikey") apiKey: String = Constant.API_KEY,
        @QueryMap options: Map<String, String> = mapOf("plot" to "full", "type" to "movie"),
        @Query("s") title: String
    ): MovieDataDto

    @GET("/")
    suspend fun getSearchResult(
        @Query("apikey") apiKey: String = Constant.API_KEY,
        @Query("type") type: String = "movie",
        @Query("s") search: String
    ): SearchResultDto
}