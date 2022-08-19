package com.monique.projetointegrador.data.remotesource

import com.example.MoviesList.data.model.movies.MovieDetailResponse
import com.example.MoviesList.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesRemoteSource {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("language") lg: String): Response<MovieList>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int, @Query("language") id: String): Response<MovieDetailResponse>


}