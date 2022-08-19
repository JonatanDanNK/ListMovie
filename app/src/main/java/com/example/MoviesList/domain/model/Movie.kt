package com.monique.projetointegrador.domain.model

import com.example.MoviesList.domain.modelsmaps.MoviesDomain
import com.google.gson.annotations.SerializedName


data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val imgHome: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("vote_average")
    val rating: Float,
    var isFavorite: Boolean = false
) {

    fun getRating(): String{
        val rating = (rating*10).toInt()
        return "$rating%"
    }
}

fun MoviesDomain.toMovie() = Movie(id = id, imgHome = imgHome, title = title, rating = rating, isFavorite = isFavorite)


