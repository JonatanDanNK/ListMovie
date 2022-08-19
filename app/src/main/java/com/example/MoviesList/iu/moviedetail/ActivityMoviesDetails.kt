package com.example.MoviesList.iu.moviedetail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.MoviesList.R
import com.example.MoviesList.databinding.ActivityMoviesDetailsBinding
import com.example.MoviesList.iu.adapter.MovieDetailsGenresRvAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import com.monique.projetointegrador.data.base.Constants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivityMoviesDetails : AppCompatActivity() {
    
    private lateinit var _mBinding: ActivityMoviesDetailsBinding
    private val dmViewModel: MovieDetailViewModel by viewModels()
    private lateinit var posterMovie: ShapeableImageView
    private lateinit var movieTitle: TextView
    private lateinit var genresRv: RecyclerView
    private lateinit var movieSynopsis: TextView
    private lateinit var returnBtn: FloatingActionButton
    private lateinit var genresRvAdapter: MovieDetailsGenresRvAdapter
    private lateinit var laguaje: String
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mBinding = ActivityMoviesDetailsBinding.inflate(layoutInflater)
        setContentView(_mBinding.root)


       toolbar()

        posterMovie = _mBinding.posterMovie
        movieTitle = _mBinding.movieTitle
        genresRv = _mBinding.genreRvMovieInfo
        movieSynopsis = _mBinding.movieSynopsis
        returnBtn = _mBinding.returnBtn

        laguaje="es-MX"

        val movieId = intent.extras?.getInt(MOVIE_ID)
        dmViewModel.getDetailMovie(movieId!!, laguaje)
        observerVMoviewDetails()
        returnBtn.setOnClickListener { finish() }
        
    }

    private fun observerVMoviewDetails(){
        dmViewModel.detailMovie.observe(this) { result ->
            if (result != null) {
                result.backdropPath?.let {
                    Glide.with(this).load(
                        Constants.BASE_URL_IMAGE.value + result.backdropPath
                    ).into(posterMovie)
                }
                movieTitle.text = result.title

                result.overview?.let {
                    movieSynopsis.text = it
                }
                genresRvAdapter = MovieDetailsGenresRvAdapter(result.genres)
                genresRv.adapter = genresRvAdapter

            }
        }
    }

    private fun toolbar() {
        setSupportActionBar(_mBinding.toolbarDetail)
        val ab: ActionBar? = supportActionBar
        if (ab != null) {
            ab.title = "Detalle de la Pelicula"

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.languages, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.es -> {
                laguaje = "es-MX"
                val movieId = intent.extras?.getInt(MOVIE_ID)
                dmViewModel.getDetailMovie(movieId!!, laguaje)

            }
            R.id.us-> {
               laguaje = "en-US"
                val movieId = intent.extras?.getInt(MOVIE_ID)
                dmViewModel.getDetailMovie(movieId!!, laguaje)

            }
        }
        return super.onOptionsItemSelected(item)
    }


    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }
}