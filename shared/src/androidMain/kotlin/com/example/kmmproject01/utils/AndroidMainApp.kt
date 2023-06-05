package com.example.kmmproject01.utils

import android.content.Context
import com.example.kmmproject01.network.Environment

object AndroidMainApp {

        // since we are using the application Context and not
        // the context per se, nothing is going to leak here
        lateinit var applicationContext: Context
        //lateinit var environment: Environment
}