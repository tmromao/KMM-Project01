package com.example.kmmproject01.localization

import android.annotation.SuppressLint
import android.content.res.Resources
import com.example.kmmproject01.utils.AndroidMainApp

@SuppressLint("DiscouragedApi")
actual fun getDefaultString(name: String): String {
    return with(AndroidMainApp.applicationContext) {
        try {
            getString(resources.getIdentifier(name, "string", packageName))
        } catch (ex: Resources.NotFoundException){
            name
        }
    }
}