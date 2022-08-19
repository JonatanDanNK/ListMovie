package com.example.MoviesList.iu.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.MoviesList.domain.usecase.DetailsMovieUsesCase
import com.monique.projetointegrador.domain.model.MovieDetail
import com.monique.projetointegrador.domain.model.toMovieDetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailsUseCase: DetailsMovieUsesCase
): ViewModel() {
    private val _detailsMovie = MutableLiveData<MovieDetail>()
    val detailMovie: LiveData<MovieDetail> = _detailsMovie

    fun getDetailMovie(movieId: Int, lg: String){
        viewModelScope.launch {
            val result = movieDetailsUseCase(movieId, lg)
            System.out.println("consumo de movieDetalles"+result)
            if(result != null){
                _detailsMovie.value = result.toMovieDetailsModel()
            }

        }
    }
}