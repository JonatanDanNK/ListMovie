package com.example.MoviesList.domain.usecase

import com.example.MoviesList.data.database.entities.toDatabase
import com.example.MoviesList.data.repository.MovieRepository
import com.example.MoviesList.domain.modelsmaps.MoviesDomain
import com.example.MoviesList.domain.modelsmaps.toDomain
import com.example.MoviesList.tool.sharepref
import com.monique.projetointegrador.domain.model.Movie
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class ListMoviesUsesCase @Inject constructor(
    private val moviesRepository: MovieRepository
) {

    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate = sdf.format(Date())

    suspend operator fun invoke(): List<MoviesDomain> {

        var response = moviesRepository.getMoviresServicesFromApi()
        val map = response
        return if(map.movieResults.isNotEmpty()
            && (sharepref.pref.getDate() == "" || sharepref.pref.getDate() != currentDate)
        ){
            sharepref.pref.deleteSession()
            sharepref.pref.saveDate(currentDate)
            val mapaux: List<Movie> = map.movieResults
            moviesRepository.clearMovies()
            moviesRepository.insertMovies(mapaux.map { it.toDatabase() })
            val map2 = mapaux.map { it.toDomain() }
            map2
        }else{
            moviesRepository.getMoviresServicesDromBd()
        }
    }
}