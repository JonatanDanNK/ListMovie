package com.example.MoviesList.data.repository

import com.example.MoviesList.data.model.movies.MovieDetailResponse
import com.example.MoviesList.data.services.MovieDestailsServices
import com.monique.projetointegrador.domain.model.MovieDetail
import com.monique.projetointegrador.domain.model.toMovieDetails
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(
    private val detailService: MovieDestailsServices
){

    suspend fun getDetailsMoviesRespository(movieId: Int, lg: String): MovieDetail{
        val result: MovieDetailResponse? =  detailService.getDetailsMovie(movieId, lg)
        return result!!.toMovieDetails()
        }
}