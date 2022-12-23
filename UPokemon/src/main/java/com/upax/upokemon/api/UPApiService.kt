package com.upax.upokemon.api

import com.upax.upokemon.data.models.responses.UPokemonDetail
import com.upax.upokemon.data.models.responses.UPokemons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UPApiService {

    @GET("pokemon")
    suspend fun getAllPokemon():Response<UPokemons>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") idPokemon: Int):Response<UPokemonDetail>
}