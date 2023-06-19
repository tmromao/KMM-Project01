package com.example.kmmproject01.utils

import com.example.kmmproject01.di.DI
import com.example.kmmproject01.network.Environment
import platform.Foundation.NSLog

actual interface CommonLogger {
    actual fun log(message: String, type: LogType){
        when(DI.Native.environment){
            Environment.INT -> {
                when(type){
                    LogType.DEBUG -> NSLog("Debug: $message - ${Environment.INT.name}")
                    LogType.ERROR -> NSLog("Error: $message - ${Environment.INT.name}")
                    LogType.INFO -> NSLog("Info: $message - ${Environment.INT.name}")
                    LogType.WARNING -> NSLog("Warning: $message - ${Environment.INT.name}")
                }
            }
            Environment.DEV -> {
                when(type){
                    LogType.DEBUG -> NSLog("Debug: $message - ${Environment.INT.name}")
                    LogType.ERROR -> NSLog("Error: $message - ${Environment.INT.name}")
                    LogType.INFO -> NSLog("Info: $message - ${Environment.INT.name}")
                    LogType.WARNING -> NSLog("Warning: $message - ${Environment.INT.name}")
                }
            }
            else -> Unit
        }

    }

}