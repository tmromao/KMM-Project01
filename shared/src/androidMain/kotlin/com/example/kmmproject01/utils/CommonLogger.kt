package com.example.kmmproject01.utils

import android.util.Log
import com.example.kmmproject01.BuildConfig

actual interface CommonLogger {
    actual fun log(message: String){
        // MAIS PARA FRENTE IREMOS USAR O ENVIRONMENT AQUI
        if(BuildConfig.DEBUG){
            Log.d(BuildConfig.BUILD_TYPE, message)
        }
    }
}