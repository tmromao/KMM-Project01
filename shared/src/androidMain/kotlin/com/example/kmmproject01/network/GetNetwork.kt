package com.example.kmmproject01.network

import com.example.kmmproject01.utils.AndroidApplication
import io.ktor.client.HttpClient

actual fun getAppEnvironment(): Environment = AndroidApplication.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)