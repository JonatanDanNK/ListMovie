package com.example.MoviesList.data.database.entities

import androidx.room.*
import com.example.MoviesList.domain.modelsmaps.MoviesDomain
import com.monique.projetointegrador.domain.model.Movie

@Entity(tableName = "movie_list")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name ="poster_path")
    val imgHome: String? = null,
    @ColumnInfo(name ="title")
    val title: String? = null,
    @ColumnInfo(name ="vote_average")
    val rating: Float,
    @ColumnInfo(name = "Favorite")
    var isFavorite: Boolean = false
)

fun MoviesDomain.toDatabase() = MovieEntity(id = id, imgHome = imgHome, title = title, rating = rating, isFavorite = isFavorite)
fun Movie.toDatabase() = MovieEntity(id = id, imgHome = imgHome, title = title, rating = rating, isFavorite = isFavorite)
