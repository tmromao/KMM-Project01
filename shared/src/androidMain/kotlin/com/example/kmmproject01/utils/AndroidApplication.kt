package com.example.kmmproject01.utils

import android.content.Context

class AndroidApplication {
    companion object {
        // since we are using the application Context and not
        // the context per se, nothing is going to leak here
        lateinit var context: Context
    }
}