package com.example.kmmproject01.network

import com.example.kmmproject01.di.DI
import com.example.kmmproject01.utils.AndroidMainApp
import io.ktor.client.HttpClient

actual fun getAppEnvironment(): Environment = DI.Native.environment
actual fun getHttpClient(clientConfig: ClientConfig): HttpClient = createOkHttpClient(clientConfig)