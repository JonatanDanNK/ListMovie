package com.example.MoviesList.iu.homemovies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.MoviesList.R
import com.example.MoviesList.databinding.FragmentHomeMoviesBinding
import com.example.MoviesList.iu.ClickListener
import com.example.MoviesList.iu.moviedetail.ActivityMoviesDetails
import com.example.MoviesList.iu.moviedetail.ActivityMoviesDetails.Companion.MOVIE_ID
import com.monique.projetointegrador.domain.model.Movie
import com.monique.projetointegrador.presentation.adapter.MoviesRvAdapter

class HomeMoviesFragment : Fragment(), ClickListener {

    private lateinit var viewModel: HomeMoviesViewModel
    private lateinit var _mBinding: FragmentHomeMoviesBinding
    private lateinit var _mAadapter: MoviesRvAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _mBinding = FragmentHomeMoviesBinding.bind(view)
        viewModel= ViewModelProvider(requireActivity()).get(HomeMoviesViewModel::class.java)

        val rvMovies = _mBinding.rvMovies

        _mAadapter = MoviesRvAdapter(context = view.context, listener = this)
        viewModel.getAllMovies()
        progressBar = _mBinding.loading

        observeMovies()
    }

    private fun observeMovies() {
        viewModel.listMovies.observe(viewLifecycleOwner,{

            if(it != emptyList<Movie>()){
                _mAadapter.dataset.clear()
                _mAadapter.dataset.addAll(it)
                _mBinding.rvMovies.adapter = _mAadapter
                progressBar.visibility = View.GONE
            }else{
                Toast.makeText(context, "Ocurrio un error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(requireContext(), ActivityMoviesDetails::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }


}