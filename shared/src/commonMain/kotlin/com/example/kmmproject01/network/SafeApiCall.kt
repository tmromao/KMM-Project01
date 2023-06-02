package com.example.kmmproject01.network

suspend fun <T:Any> safeApiCall(apiCall: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(data = apiCall.invoke())
    } catch (e: Exception) {
        NetworkResult.Exception(e)
    }
}
