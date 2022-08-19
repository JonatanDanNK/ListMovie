package com.example.MoviesList.data.di

import android.content.Context
import androidx.room.Room
import com.example.MoviesList.data.database.MoviesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val MOVIES_LIST = "moviesdatabase"
    @Singleton
    @Provides
    fun providerRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, MoviesDataBase::class.java, MOVIES_LIST).build()

    @Singleton
    @Provides
    fun provideMoviesDao(db:MoviesDataBase) = db.getMoviesDao()
}