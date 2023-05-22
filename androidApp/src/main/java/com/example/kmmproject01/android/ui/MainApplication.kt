package com.example.kmmproject01.android.ui

import android.app.Application
import android.content.Context
import com.example.kmmproject01.utils.AndroidApplication

class MainApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            // inject the application context into android main
            AndroidApplication.context = it
        }
    }
}