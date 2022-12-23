package com.upax.upokemon.data

sealed class UPResult<out R> {
    object Start : UPResult<Nothing>()
    object Loading : UPResult<Nothing>()
    object NoConnection : UPResult<Nothing>()
    data class Error(val e: String) : UPResult<Nothing>()
    data class Success<out T>(val data: T) : UPResult<T>()
    object SuccessEmpty: UPResult<Nothing>()
}