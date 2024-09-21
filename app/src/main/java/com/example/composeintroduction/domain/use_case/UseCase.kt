package com.example.composeintroduction.domain.use_case

data class UseCase(
    val getMovieUseCase: GetMovieUseCase,
    val getSearchResultUseCase: GetSearchUseCase
)
