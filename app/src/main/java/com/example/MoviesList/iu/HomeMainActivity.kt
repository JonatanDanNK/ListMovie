package com.example.MoviesList.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.MoviesList.databinding.HomeMainBinding
import com.example.MoviesList.tool.Pref
import com.example.MoviesList.tool.sharepref.pref
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeMainActivity : AppCompatActivity() {


    private lateinit var _mBinding: HomeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mBinding = HomeMainBinding.inflate(layoutInflater)
        setContentView(_mBinding.root)
        pref = Pref(this)
    }
}

