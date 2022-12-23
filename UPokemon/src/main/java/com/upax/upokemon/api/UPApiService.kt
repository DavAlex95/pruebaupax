package com.upax.upokemon.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UPApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") key:String):Response<>
}