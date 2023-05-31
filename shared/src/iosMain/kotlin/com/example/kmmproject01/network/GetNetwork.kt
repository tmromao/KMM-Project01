package com.example.kmmproject01.network

import io.ktor.client.HttpClient

actual fun getAppEnvironment(): Environment = DI.Native.environment

actual fun getHttpClient(clientConfig: ClientConfig): HttpClient {
    return HttpClient(Darwin){
        engine {
            configureRequest {
                // setAllowsCellularAccess(true)
            }
        }
    }
}