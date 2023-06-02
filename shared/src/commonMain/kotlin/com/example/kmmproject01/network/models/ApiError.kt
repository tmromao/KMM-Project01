package com.example.kmmproject01.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 1) Junto da "equipa de backend" acorda-se como o erro vai ser retornado
// 2) Exemplo de erro: { "code": "404", "message": "Not found" }
@Serializable
data class ApiError(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
)