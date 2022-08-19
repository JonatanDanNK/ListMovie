package com.example.MoviesList.data.services

import com.example.MoviesList.domain.model.MovieList
import com.monique.projetointegrador.data.remotesource.MoviesRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesServiceImpl @Inject constructor(
    private val moviesRemoteSource:MoviesRemoteSource
)  {
    val ld="es-MX"
    suspend fun getPopularMovies(): MovieList {
       return withContext(Dispatchers.IO){
           val result = moviesRemoteSource.getPopularMovies(ld)
           result.body() ?: MovieList(emptyList())
       }
    }
}