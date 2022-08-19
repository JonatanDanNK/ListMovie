package com.example.MoviesList.domain.model

import com.google.gson.annotations.SerializedName
import com.monique.projetointegrador.domain.model.Movie

data class MovieList(
    @SerializedName("results")
    val movieResults: List<Movie>
)

