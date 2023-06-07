package com.example.kmmproject01.settings

import com.example.kmmproject01.di.DI

interface SettingsService {

    // Accesso fácil e comum tanto para iOS como para Android
    companion object {
        val instance by DI.inject<SettingsService>()
    }

    // fun storeAppLanguage(language: Language)
    //fun restoreAppLanguage(language: Language): Language
    //...outras preferências e configurações que seu App tenha
}

class AppSettings : SettingsService {

    /*private val settings = getSettings()
    override fun storeAppLanguage(language: Language) {
        settings?.let {
            it.putString(SettingsKeys.PREF_KEY_LANGUAGE, language.language)
            it.putString(SettingsKeys.PREF_KEY_LANGUAGE_REGION, language.region)
        }
    }*/

    /*override fun restoreAppLanguage(language: Language): Language {
        val defaultLanguage = Language.getDefaultLanguage()
        settings?.let {
            val appIsoCode = it.getString(SettingsKeys.PREF_KEY_LANGUAGE, defaultLanguage.language)
            val appRegion = it.getString(SettingsKeys.PREF_KEY_LANGUAGE_REGION, defaultLanguage.region)
            return Language.getLanguageByIsoCodeAndRegion(appIsoCode, appRegion)
        }
        return defaultLanguage
    }*/


}