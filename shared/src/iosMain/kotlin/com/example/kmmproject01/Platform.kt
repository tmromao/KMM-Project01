package com.example.kmmproject01

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual abstract class BaseSharedViewModel {

    actual val scope: CoroutineScope = MainScope()
    protected actual open fun onCleared() {
        // Outras coisas que precisam ser feitas quando o ViewModel é destruído
    }

    fun clear() {
        onCleared()
        scope.cancel()
    }
}