package com.example.MoviesList.data.di

import com.monique.projetointegrador.data.base.Constants
import com.monique.projetointegrador.data.remotesource.MoviesRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)
        okHttpClient.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url
            val urlWithKey = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", Constants.PRIVATE_KEY.value)
                .build()

            chain.proceed(original.newBuilder().url(urlWithKey).build())
        }

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL.value)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }

    @Singleton
    @Provides
    fun proviedMoviesRemoteSource(retrofit: Retrofit): MoviesRemoteSource {
        return retrofit.create(MoviesRemoteSource::class.java)
    }
}