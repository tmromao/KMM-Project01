package com.example.kmmproject01.settings

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.example.kmmproject01.utils.AndroidMainApp
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

// Creates a shared prefs with name: {context.getPackageName() + "_preferences"} AND MODE_PRIVATE
val delegate: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(AndroidMainApp.applicationContext)

actual fun getSettings(): Settings {
    return SharedPreferencesSettings(delegate)
}