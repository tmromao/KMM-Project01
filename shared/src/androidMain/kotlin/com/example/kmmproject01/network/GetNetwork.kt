package com.example.kmmproject01.network

import com.example.kmmproject01.utils.AndroidMainApp
import io.ktor.client.HttpClient

actual fun getAppEnvironment(): Environment = AndroidMainApp.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)