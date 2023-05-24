package com.example.kmmproject01

import kotlinx.coroutines.CoroutineScope

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect abstract class BaseSharedViewModel() {
    val scope: CoroutineScope
    protected fun onCleared()
}