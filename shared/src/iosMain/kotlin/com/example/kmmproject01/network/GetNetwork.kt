package com.example.kmmproject01.network

import com.example.kmmproject01.di.DI
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

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