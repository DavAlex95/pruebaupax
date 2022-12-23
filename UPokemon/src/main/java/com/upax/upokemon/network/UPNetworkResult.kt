package com.upax.upokemon.network


sealed class UPNetworkResult<out T, out U> {
    data class Success<out T>(val data: T) : UPNetworkResult<T, Nothing>()
    data class Error<out U>(val error: String, val bodyError: String?) : UPNetworkResult<Nothing, U>()
    data class ErrorCode<out U>(val error: UPCError) : UPNetworkResult<Nothing, U>()
}

data class UPCError(
    val code: Int,
    val message: String = ""
)