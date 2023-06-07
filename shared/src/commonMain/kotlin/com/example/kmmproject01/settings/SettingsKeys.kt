package com.example.kmmproject01.settings

// 1) Add dependencies
// 2) Create, think about keys, new and migration
// 3) Create Settings in both platforms
// 4) Create service settings in both platforms\
// 5) Add dependency injection mechanism
object SettingsKeys {
    //***** PAY ATTENTION ********
    // Do not change this prop name. It must be compatible with old version
    // ********
    const val PREF_KEY_LANGUAGE = "pref_key_app_language"
    const val PREF_KEY_LANGUAGE_REGION = "pref_key_app_region"
}