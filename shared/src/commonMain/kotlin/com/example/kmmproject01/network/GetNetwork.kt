package com.example.kmmproject01.network

import io.ktor.client.HttpClient

expect fun getAppEnvironment(): Environment
expect fun getHttpClient(clientConfig: ClientConfig):HttpClient