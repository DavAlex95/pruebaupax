package com.upax.upokemon.data.repository

import com.google.gson.Gson
import com.upax.upokemon.api.UPApiService
import com.upax.upokemon.data.models.responses.UPokemonDetail
import com.upax.upokemon.extensions.fromJson
import com.upax.upokemon.network.UPBaseDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UPokemonRepository @Inject constructor(
    private val service:UPApiService
): UPBaseDataSource() {

    fun getPokemonDetail(value:Int)= flow {

        val result= performUpdateOperation(
            {
                service.getPokemonDetail(value)
            },
            {
                val json= Gson().toJson(it)
                Gson().fromJson<UPokemonDetail>(json.toString())
            },{

            }
        )

        emit(result)
    }
}