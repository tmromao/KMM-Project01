package com.example.kmmproject01.utils

import android.util.Log
import com.example.kmmproject01.BuildConfig
import com.example.kmmproject01.di.DI
import com.example.kmmproject01.network.Environment

actual interface CommonLogger {
    actual fun log(message:String, type: LogType){
        when (DI.Native.environment) {
            Environment.INT -> {
                val integration = Environment.INT.name
                when(type){
                    LogType.DEBUG -> Log.d(integration, message)
                    LogType.ERROR -> Log.e(integration, message)
                    LogType.INFO -> Log.i(integration, message)
                    LogType.WARNING -> Log.w(integration, message)
                }
            }
            Environment.DEV -> {
                val development = Environment.DEV.name
                when(type){
                    LogType.DEBUG -> Log.d(development, message)
                    LogType.ERROR -> Log.e(development, message)
                    LogType.INFO -> Log.i(development, message)
                    LogType.WARNING -> Log.w(development, message)
                }
            }
            else -> Unit
        }
    }
}