package com.example.kmmproject01.network

/**
 * Environment variable used while creating different http clients
 * @param host the host name of the desired environment
 * @param certificatePinningHashes hashes to be pinned if any (Only prepared for later)
 * */
enum class Environment(
    val host: String,
    val certificatePinningHashes: List<String> = emptyList(),
) {
    PROD(
        "https://api.YOURCOMPANY.com/",
        certificatePinningHashes = listOf(
            "sha256/rE/SEU_HASH_PINNING_AQUI=",
        )
    ),
    DEV("https://api.github.com/"),
    INT("https://api.github.com/");

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
