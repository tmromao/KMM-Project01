package com.example.kmmproject01.network

// Estado da arte - TODO - Analisar esta classe. sealed class n\ao funciona no iOS
// https://kotlinlang.org/docs/reference/sealed-classes.html
// devia ser substituido por uma abstract class

sealed class NetworkResult<T>(
    val data: T? = null,
    val errorCode: String? = null,
    val errorMessage: String? = null,
    val exception: Throwable? = null,
) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(code: String, errorMessage: String?) : NetworkResult<T>(errorCode = code, errorMessage = errorMessage)
    class Exception<T>(exception: Throwable?) : NetworkResult<T>(exception = exception)
}