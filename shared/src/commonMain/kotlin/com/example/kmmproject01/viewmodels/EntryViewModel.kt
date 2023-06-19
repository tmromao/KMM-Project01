package com.example.kmmproject01.viewmodels

import com.example.kmmproject01.BaseSharedViewModel
import com.example.kmmproject01.network.ApiEndpoints
import com.example.kmmproject01.network.ClientConfig
import com.example.kmmproject01.network.NetworkResult
import com.example.kmmproject01.network.getAppEnvironment
import com.example.kmmproject01.network.getHttpClient
import com.example.kmmproject01.network.models.Entry
import com.example.kmmproject01.repository.EntryRepository
import com.example.kmmproject01.utils.CommonLogger
import com.example.kmmproject01.utils.CommonLoggerImpl
import com.example.kmmproject01.utils.logE
import com.example.kmmproject01.utils.logI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EntryViewModel : BaseSharedViewModel() {

    private lateinit var storyRepository: EntryRepository
    private val logContext = "EntryViewModel"
    //private val logger: CommonLogger = CommonLoggerImpl()

    private val _entries = MutableStateFlow<List<Entry>?>(null)
    val entries: StateFlow<List<Entry>?>
        get() {
            return _entries
        }
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?>
        get() {
            return _error
        }

    init {
        initEndPointService()
    }

    private fun initEndPointService() {
        val httpClient = getHttpClient(
            ClientConfig(
                environment = getAppEnvironment(),
                userAgent = "Android"
            )
        )
        storyRepository = EntryRepository(ApiEndpoints(httpClient, getAppEnvironment()))
    }

    fun fetchEntries() {
        scope.launch {
            storyRepository.fetchEntries().collect { networkResult ->
                when (networkResult) {
                    is NetworkResult.Success -> _entries.emit(networkResult.data).also {
                        logI(logContext,"Entries fetched successfully")
                    }

                    is NetworkResult.Error -> _entries.emit(networkResult.data).also {
                        logE(logContext,"Entries error: ${networkResult.errorMessage}")
                    }

                    is NetworkResult.Exception -> _error.emit(networkResult.exception?.message).also {
                        logE(logContext, "Entries exception: ${networkResult.exception?.message}")
                    }
                }
            }
        }
    }

}