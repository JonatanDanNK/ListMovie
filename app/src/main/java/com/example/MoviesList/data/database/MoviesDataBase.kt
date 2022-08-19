package com.example.MoviesList.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.MoviesList.data.database.dao.MoviesDao
import com.example.MoviesList.data.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version=1)
abstract class MoviesDataBase : RoomDatabase(){
    abstract fun getMoviesDao():MoviesDao
}