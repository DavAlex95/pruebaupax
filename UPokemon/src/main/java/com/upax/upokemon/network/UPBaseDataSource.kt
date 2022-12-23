package com.upax.upokemon.network

import android.util.Log
import com.google.gson.Gson
import retrofit2.Response

abstract class UPBaseDataSource {

    protected suspend fun <I, O> performUpdateOperation(
        call: suspend () -> Response<I>,
        deserialize: (I?) -> O?,
        saveResult: suspend (O) -> Unit,
    ): UPNetworkResult<O, String> {
        try {
            val response = call()
            Log.e(this.javaClass.name, "request: ${response.raw().request()}")
            return if (response.isSuccessful && response.body() != null) {
                val result = deserialize(response.body())
                Log.e(this.javaClass.name, "response: ${Gson().toJson(result)}")
                if (result != null) {
                    saveResult(result)
                    UPNetworkResult.Success(result)
                } else {

                    UPNetworkResult.Error("","errorResponse")
                }
            } else {
                UPNetworkResult.Error(" ${response.code()} ${response.headers()}","errorResponse")
            }
        } catch (e: Exception) {
            Log.e(this.javaClass.name, "exception: " + (e.message ?: e.toString()))
            return UPNetworkResult.Error(e.message ?: e.toString(),null)
        }
    }
}