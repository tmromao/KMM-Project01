@file:OptIn(ExperimentalSerializationApi::class)

package com.example.kmmproject01.network

import com.example.kmmproject01.network.models.ApiError
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.plugins.BodyProgress.Plugin.install
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.HttpStatusCode
import io.ktor.http.userAgent
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

// Para ver e rever esta implementacao. naotar que defino o que quero instalar e depois faço a implementaçao
// implementando funçoes que extenden o HttpClientConfig<OkHttpConfig> e depois chamo essas funçoes
// dentro do createOkHttpClient
fun createOkHttpClient(clientConfig: ClientConfig): HttpClient {
    return HttpClient(OkHttp) {
        installJsonSerializer()
        installRequestTimeouts()
        installDefaultUserAgentAndHeader(clientConfig)
        installResponseValidator()
    }
}

fun HttpClientConfig<OkHttpConfig>.installJsonSerializer() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        })
    }
}

private fun HttpClientConfig<OkHttpConfig>.installRequestTimeouts() {
    install(
        HttpTimeout
    ) {
        requestTimeoutMillis = 10_000
        socketTimeoutMillis = 10_000
        connectTimeoutMillis = 10_000
    }
}

fun HttpClientConfig<OkHttpConfig>.installDefaultUserAgentAndHeader(clientConfig: ClientConfig) {
    defaultRequest {
        userAgent(clientConfig.userAgent)
    }
}

//
private fun HttpClientConfig<OkHttpConfig>.installResponseValidator() {
    HttpResponseValidator {
        validateResponse { response ->
            if(response.status != HttpStatusCode.OK){
                try {
                    val apiError = response.body<ApiError>()
                    throw YourCompanyException(message = "YourCompanyExceptioin", apiError = apiError)
                } catch (e: Throwable){
                    throw Exception("${response.status}: ${response.body<String>()}",e)
                }
            }
        }
    }
}