package com.example.MoviesList.domain.usecase

import com.example.MoviesList.data.repository.MovieDetailsRepository
import com.example.MoviesList.domain.modelsmaps.MovieDetailDomian
import com.example.MoviesList.domain.modelsmaps.toDetailDomain
import javax.inject.Inject

class DetailsMovieUsesCase @Inject constructor(
    private val detailsMovieRepository: MovieDetailsRepository
){
    suspend operator fun invoke(movieId: Int, lg: String): MovieDetailDomian{
        var response = detailsMovieRepository.getDetailsMoviesRespository(movieId, lg)
        return response.toDetailDomain()
    }

}