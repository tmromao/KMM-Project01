package com.example.kmmproject01.android.ui

import android.app.Application
import android.content.Context
import com.example.kmmproject01.android.BuildConfig
import com.example.kmmproject01.di.DI
import com.example.kmmproject01.network.Environment
import com.example.kmmproject01.utils.AndroidMainApp

class MainApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject the application context into android main
            AndroidMainApp.applicationContext = it
        }
        setEnvironment()
    }

    // Apenas para fins didáticos, para mais detalhes ver:
    // https://developer.android.com/studio/build/build-variants#kts
    // https://developer.android.com/studio/build
    private fun setEnvironment(){
        DI.Native.environment = Environment.getEnvironmentByBuildFlavor(BuildConfig.FLAVOR)
    }
}