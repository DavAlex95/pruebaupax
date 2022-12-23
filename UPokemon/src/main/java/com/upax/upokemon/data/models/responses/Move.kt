package com.upax.upokemon.data.models.responses

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)