package com.example.MoviesList.data.services

import com.example.MoviesList.data.model.movies.MovieDetailResponse
import com.monique.projetointegrador.data.remotesource.MoviesRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDestailsServices @Inject constructor(
    private val moviesRemoteSource: MoviesRemoteSource
){
    suspend fun getDetailsMovie(movieId: Int, lg: String): MovieDetailResponse? {
       return withContext(Dispatchers.IO){
           val result = moviesRemoteSource.getMovieDetails(movieId, lg)
           result.body()
       }
    }
}