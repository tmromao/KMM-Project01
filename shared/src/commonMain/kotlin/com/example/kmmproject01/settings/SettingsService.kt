package com.example.kmmproject01.settings

import com.example.kmmproject01.di.DI
import com.example.kmmproject01.localization.Language

// 1) DIAGRAMA SERVICOS
// 2) DEFINIR INTERFACE DE SERVICO
// 3) IMPLEMENTAR SERVICO INTERNO
// 4) ADICIONAR SERVICO A INJECÃO DE DEPENDENCIA
interface SettingsService {

    // Accesso fácil e comum tanto para iOS como para Android
    companion object {
        val instance by DI.inject<SettingsService>()
    }

    fun getLanguage(): Language?
    fun setLanguage(language: Language)

    fun getRegion(): String?
    fun setRegion(region: String)

    // fun storeAppLanguage(language: Language)
    //fun restoreAppLanguage(language: Language): Language
    //...outras preferências e configurações que seu App tenha
}

internal class AppSettings: SettingsService {

    private val settings = getSettings()

    override fun getLanguage(): Language? {
        val langIsoCode = settings?.getStringOrNull(SettingsKeys.PREF_KEY_LANGUAGE)

        if (langIsoCode.isNullOrBlank()) {
            return null
        }

        return when (langIsoCode) {
            Language.DE_CH.isoCode -> migrateLegacyLanguage(langIsoCode)
            Language.IT_CH.isoCode -> migrateLegacyLanguage(langIsoCode)
            Language.FR_CH.isoCode -> migrateLegacyLanguage(langIsoCode)
            else -> Language.valueOf(langIsoCode)
        }
    }

    // MECANISMO PARA MIGRAR APP ANTIGAS E POSSIBILITAR FUTURAS MIGRACÕES
    private fun migrateLegacyLanguage(isoCode: String): Language {
        val region = settings?.getStringOrNull(SettingsKeys.PREF_KEY_LANGUAGE_REGION)

        if (region.isNullOrBlank()) {
            return Language.getDefaultLanguageByIsoCode(isoCode)
        }

        return Language.getLanguageByIsoCodeAndRegion(isoCode, region)
    }

    override fun setLanguage(language: Language) {
        settings?.putString(SettingsKeys.PREF_KEY_LANGUAGE, language.name)
    }

    override fun getRegion(): String? {
        return settings?.getStringOrNull(SettingsKeys.PREF_KEY_LANGUAGE_REGION)
    }
    override fun setRegion(region: String) {
        settings?.putString(SettingsKeys.PREF_KEY_LANGUAGE_REGION, region)
    }
}