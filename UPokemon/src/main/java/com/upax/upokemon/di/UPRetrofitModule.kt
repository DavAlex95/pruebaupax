package com.upax.upokemon.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.upax.upokemon.api.UPApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UPSCRetrofitModule {

    @Provides
    fun provideRetrofit(@ApplicationContext appContext: Context, gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
    }

    @Provides
    fun provideInterceptor(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder().
        retryOnConnectionFailure(false).
        readTimeout(180, TimeUnit.SECONDS).
        connectTimeout(180, TimeUnit.SECONDS).
        addInterceptor(loggingInterceptor)
        return httpClient.build()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Provides
    fun provideApiService(retrofit: Retrofit): UPApiService = retrofit.create(
        UPApiService::class.java)

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}
