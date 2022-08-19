package com.example.MoviesList.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.MoviesList.data.database.entities.MovieEntity

@Dao
interface MoviesDao {

    @Query("SELECT *  FROM movie_list ORDER BY id")
    suspend fun getAllMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movie_list")
    suspend fun deleteAllMovies()
}