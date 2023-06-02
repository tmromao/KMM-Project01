package com.example.kmmproject01.network

import com.example.kmmproject01.network.models.Entry
import com.example.kmmproject01.network.models.EntryResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

//Interface para definir os endpoints
//Cada endpoint é uma interface
//Cada endpoint tem uma implementação
//Cada implementação tem um httpClient e um env
//Cada implementação tem um método que retorna um Flow<NetworkResult<T>>
interface Endpoints {
    interface Entries {
        suspend fun getEntries(): Flow<NetworkResult<List<Entry>>>
    }

    interface EndpointA
    interface EndpointB
    interface EndpointC
}

//Implementação do endpoint Entries
//Recebe um httpClient e um env
//Retorna um Flow<NetworkResult<List<Entry>>>
//O método getEntries() retorna um Flow<NetworkResult<List<Entry>>>
//O método getEntries() chama o safeApiCall() que recebe um suspend () -> T e retorna um NetworkResult<T>
//O método getEntries() chama o httpClient.get() que recebe uma urlString e retorna um EntryResponse
class ApiEndpoints(private val httpClient: HttpClient, private val env: Environment) : Endpoints.Entries {

    override suspend fun getEntries(): Flow<NetworkResult<List<Entry>>> {
        val networkResult = safeApiCall {
            httpClient.get(urlString = "${env.hostTest}/random").body<EntryResponse>().entries.toList()
        }
        //flowOf() cria um Flow<T> a partir de um valor
        return flowOf(networkResult)
    }
}