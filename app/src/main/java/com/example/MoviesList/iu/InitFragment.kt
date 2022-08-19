package com.example.MoviesList.iu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.MoviesList.R
import com.example.MoviesList.databinding.FragmentInitBinding

class InitFragment : Fragment() {

    private lateinit var _mBinding: FragmentInitBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_init, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _mBinding = FragmentInitBinding.bind(view)

        val btMovies= _mBinding.imgMovies

        btMovies.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.homeMoviesFragment)
        }
    }

}