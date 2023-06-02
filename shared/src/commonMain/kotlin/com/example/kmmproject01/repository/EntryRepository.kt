package com.example.kmmproject01.repository

import com.example.kmmproject01.network.Endpoints
import com.example.kmmproject01.network.NetworkResult
import com.example.kmmproject01.network.models.Entry
import kotlinx.coroutines.flow.Flow

// 1) Como criar o repositorio
// 2) Como criar o viewmodel para emitir um flow
// 3) Como usar o viewmodel na prática dentro da view

interface EntrySourceType {
    suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>>
}

//Implementação do EntrySourceType
//Recebe um endpoint
//Retorna um Flow<NetworkResult<List<Entry>>>
// método assincrono
class EntryRepository(private val entryEndpoint: Endpoints.Entries) : EntrySourceType {
    override suspend fun fetchEntries(): Flow<NetworkResult<List<Entry>>> {
        return entryEndpoint.getEntries()
    }
}