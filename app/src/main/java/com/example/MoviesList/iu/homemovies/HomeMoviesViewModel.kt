package com.example.MoviesList.iu.homemovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.MoviesList.domain.usecase.ListMoviesUsesCase
import com.monique.projetointegrador.domain.model.Movie
import com.monique.projetointegrador.domain.model.toMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMoviesViewModel @Inject constructor(
    private val moviesUsesCase: ListMoviesUsesCase
): ViewModel() {

    private val _listMovies = MutableLiveData<List<Movie>>()
    val listMovies : LiveData<List<Movie>> = _listMovies

    fun getAllMovies() {
        viewModelScope.launch {

            val result = moviesUsesCase()
            System.out.println(result + "holi")
            if (result != emptyList<Movie>()) {
                _listMovies.value = result.map { it.toMovie() }
                System.out.println("Hola")
            } else {
                _listMovies.value = mutableListOf()
            }
        }
    }
}