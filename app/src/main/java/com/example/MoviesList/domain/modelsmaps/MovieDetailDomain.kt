package com.example.MoviesList.domain.modelsmaps

import com.monique.projetointegrador.domain.model.Genre
import com.monique.projetointegrador.domain.model.MovieDetail

data class MovieDetailDomian (
    val backdropPath: String? = null,
    val genres: List<Genre>,
    val id: Int,
    val overview: String? = null,
    val title: String
    )
fun MovieDetail.toDetailDomain() = MovieDetailDomian(backdropPath = backdropPath, genres = genres, id = id, overview = overview, title = title)