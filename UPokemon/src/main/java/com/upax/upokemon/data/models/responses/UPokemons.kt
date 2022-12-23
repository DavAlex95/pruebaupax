package com.upax.upokemon.data.models.responses

data class UPokemons(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)