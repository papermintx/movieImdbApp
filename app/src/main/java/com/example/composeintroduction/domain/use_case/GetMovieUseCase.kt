package com.example.composeintroduction.domain.use_case

import com.example.composeintroduction.data.dto.MovieDataDto
import com.example.composeintroduction.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(title: String) : Flow<MovieDataDto> = flow{
        emit(repository.getMovieData(title))
    }
}