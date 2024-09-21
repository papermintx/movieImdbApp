package com.example.composeintroduction.domain.use_case

import com.example.composeintroduction.data.dto.SearchResultDto
import com.example.composeintroduction.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSearchUseCase @Inject constructor(
    private val repository: RemoteDataRepository
){
    suspend operator fun invoke(search: String) : Flow<SearchResultDto> = flow{
        emit(repository.getSearchResult(search))
    }
}