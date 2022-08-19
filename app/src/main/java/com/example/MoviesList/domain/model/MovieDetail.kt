package com.monique.projetointegrador.domain.model

import com.example.MoviesList.data.model.movies.MovieDetailResponse
import com.example.MoviesList.domain.modelsmaps.MovieDetailDomian


data class MovieDetail(
    val backdropPath: String? = null,
    val genres: List<Genre>,
    val id: Int,
    val overview: String? = null,
    val title: String
)

fun MovieDetailResponse.toMovieDetails() = MovieDetail(backdropPath = backdropPath, genres = genres, id = id, overview = overview, title = title)
fun MovieDetailDomian.toMovieDetailsModel() = MovieDetail(backdropPath = backdropPath, genres = genres, id = id, overview = overview, title = title)

