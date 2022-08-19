package com.example.MoviesList.data.model.movies

import com.google.gson.annotations.SerializedName
import com.monique.projetointegrador.domain.model.Genre
import com.monique.projetointegrador.domain.model.MovieDetail

data class MovieDetailResponse(

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("title")
    val title: String
)

fun MovieDetail.toDomain() = MovieDetailResponse(backdropPath, genres, id, overview, title)
