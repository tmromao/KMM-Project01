package com.example.kmmproject01.utils

actual interface CommonLogger {
    actual fun log(message: String){
        // MAIS PARA FRENTE IREMOS USAR O ENVIRONMENT AQUI
        if(Platform.isDebugBinary){
            // NSLog("\\%@: $message", "DEBUG")
        }
    }
}