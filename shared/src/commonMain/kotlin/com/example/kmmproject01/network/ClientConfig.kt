package com.example.kmmproject01.network

// 1) Create client config
// 2) Create http client
// 3) Create o OK_HTTP client factory
// 4) Create a Ktor client factory

/**
 * Client configuration to be applied whenever a new [HttpClient] is created.
 *
 * */
data class ClientConfig(
    /** To be used as environment switcher */
    val environment: Environment,

    /** To be used while sending requests "Mobile", "Web" or any other identifier you define */
    var userAgent: String

)