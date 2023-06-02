package com.example.kmmproject01.network

/**
 * Environment variable used while creating different http clients
 * @param host the host name of the desired environment
 * @param certificatePinningHashes hashes to be pinned if any (Only prepared for later)
 * */
enum class Environment(
    val host: String,
    val certificatePinningHashes: List<String> = emptyList(),
    val hostTest: String = ""
) {
    PROD(
        "https://api.YOURCOMPANY.com/",
        certificatePinningHashes = listOf(
            "sha256/rE/SEU_HASH_PINNING_AQUI=",
        )
    ),
    INT("https://api.publicapis.org/"),
    DEV(
        host = "https://api.github.com/",
        certificatePinningHashes = listOf(
            "sha256/rE/SEU_HASH_PINNING_AQUI=",
        ),
        hostTest = "https://api.publicapis.org"
    );


    companion object {
        fun getEnvironmentByBuildFlavor(buildFlavor: String): Environment {
            return when (buildFlavor) {
                "production" -> PROD
                "development" -> DEV
                "integration" -> INT
                else -> PROD
            }
        }
    }
}
