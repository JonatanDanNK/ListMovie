package com.example.MoviesList.data.repository

import com.example.MoviesList.data.database.dao.MoviesDao
import com.example.MoviesList.data.database.entities.MovieEntity
import com.example.MoviesList.data.services.MoviesServiceImpl
import com.example.MoviesList.domain.model.MovieList
import com.example.MoviesList.domain.modelsmaps.MoviesDomain
import com.example.MoviesList.domain.modelsmaps.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MoviesServiceImpl,
    private val moviesDao: MoviesDao
){

    suspend fun getMoviresServicesFromApi(): MovieList{
        return movieService.getPopularMovies()
    }

    suspend fun getMoviresServicesDromBd(): List<MoviesDomain> {
        val response: List<MovieEntity> = moviesDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertMovies(movies:List<MovieEntity>){
        moviesDao.insertAllMovies(movies)
    }

    suspend fun clearMovies() {
        moviesDao.deleteAllMovies()
    }
}