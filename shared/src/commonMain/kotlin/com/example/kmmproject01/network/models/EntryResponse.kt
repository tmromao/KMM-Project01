package com.example.kmmproject01.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// 1) Define the data model (EntryResponse)
// 2) Create the error data model (APiError)
// 3) Create the network Api response (NetworkResult)
// 4) Map the network Api result (SafeApiCall)
// 5) Specify the network Api endpoints in the environment variables (Environment)
// 6) Specify APi endpoints (ApiEndPoints)

// Search: Json to Kotlin data class online generator
// https://json2kt.com/
@Serializable
data class EntryResponse(
    @SerialName("count") var count: Int? = null,
    @SerialName("entries") var entries: ArrayList<Entry> = arrayListOf(),
)

@Serializable
data class Entry(
    @SerialName("API") var api: String? = null,
    @SerialName("Description") var description: String? = null,
    @SerialName("Auth") var auth: String? = null,
    @SerialName("HTTPS") var https: Boolean? = null,
    @SerialName("Cors") var cors: String? = null,
    @SerialName("Link") var link: String? = null,
    @SerialName("Category") var category: String? = null,
)