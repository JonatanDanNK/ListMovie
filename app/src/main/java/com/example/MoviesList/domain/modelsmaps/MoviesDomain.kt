package com.example.MoviesList.domain.modelsmaps

import com.example.MoviesList.data.database.entities.MovieEntity
import com.monique.projetointegrador.domain.model.Movie

data class MoviesDomain(

    val id: Int,
    val imgHome: String? = null,
    val title: String? = null,
    val rating: Float,
    var isFavorite: Boolean = false,
)
fun Movie.toDomain() = MoviesDomain(id = id, imgHome = imgHome, title = title, rating = rating, isFavorite = isFavorite)
fun MovieEntity.toDomain() = MoviesDomain(id = id, imgHome = imgHome, title = title, rating = rating, isFavorite = isFavorite)

