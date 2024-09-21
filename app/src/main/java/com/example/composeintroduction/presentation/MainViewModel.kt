package com.example.composeintroduction.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeintroduction.data.dto.toMovieData
import com.example.composeintroduction.data.dto.toSearchResult
import com.example.composeintroduction.domain.model.MovieData
import com.example.composeintroduction.domain.model.SearchResult
import com.example.composeintroduction.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import com.example.composeintroduction.util.Result
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _movieDataResponse =
        MutableStateFlow<Result<MovieData>>(Result.Idle)
    val movieDataResponse = _movieDataResponse.asStateFlow()

    private val _searchResponse =
        MutableStateFlow<Result<SearchResult>>(Result.Idle)
    val searchResponse = _searchResponse.asStateFlow()

    fun getMovieData(
        title: String
    ) = viewModelScope.launch {
        useCase.getMovieUseCase(title)
            .onStart {
                _movieDataResponse.value = Result.Loading
            }.catch {
                _movieDataResponse.value = Result.Error(it)
            }.collect {
                val result: MovieData = it.toMovieData()
                _movieDataResponse.value = Result.Success(result)
            }
    }

    fun getSearchResult(
        search: String
    ) = viewModelScope.launch {
        useCase.getSearchResultUseCase(search)
            .onStart {
                _searchResponse.value = Result.Loading
            }.catch {
                _searchResponse.value = Result.Error(it)
            }.collect {
               val result = it.toSearchResult()
                _searchResponse.value = Result.Success(result)
            }
    }
}