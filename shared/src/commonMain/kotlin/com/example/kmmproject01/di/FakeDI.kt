package com.example.kmmproject01.di

import com.example.kmmproject01.network.Environment

internal fun FakeDI() {
    DI.Native.environment = Environment.DEV

}