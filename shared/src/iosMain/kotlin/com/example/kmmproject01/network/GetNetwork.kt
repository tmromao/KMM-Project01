package com.example.kmmproject01.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual fun getAppEnvironment(): Environment = iOSApp.environment

actual fun getHttpClient(clientConfig: ClientConfig): HttpClient {
    return HttpClient(Darwin){
        engine {
            configureRequest {
                // setAllowsCellularAccess(true)
            }
        }
    }
}