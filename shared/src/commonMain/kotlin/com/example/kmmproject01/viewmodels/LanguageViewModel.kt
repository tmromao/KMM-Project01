package com.example.kmmproject01.viewmodels

import com.example.kmmproject01.BaseSharedViewModel
import com.example.kmmproject01.adobe.AnalyticsService
import com.example.kmmproject01.localization.Language
import com.example.kmmproject01.localization.LanguagePickerTexts
import com.example.kmmproject01.localization.LocalizationService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class LanguagePickerViewModel (
    val translations: LanguagePickerTexts
) : BaseSharedViewModel() {

    // Way to define default params so that it works on iOS too.
    constructor() : this(
        translations = LanguagePickerTexts()
    )

    private val localisation: LocalizationService = LocalizationService.instance
    //private val analytics: AnalyticsService = AnalyticsService.instance

    private var currentSelectedLang = Language.fallback

    private val _language = MutableStateFlow(currentSelectedLang)
    open val language: StateFlow<Language> = _language

    init {
        restoreAppDefaultLanguageFromSettings()
    }

    open fun setLanguage(language: Language) {
        if (currentSelectedLang != language) {
            //analytics.setProperty(AnalyticsProperty.AppLanguage, language.isoCode)
            currentSelectedLang = language
            localisation.setLanguage(language)
            scope.launch {
                _language.emit(language)
            }
        }
    }

    private fun restoreAppDefaultLanguageFromSettings() = setLanguage(getCurrentLanguage())

    fun getCurrentLanguage(): Language {
        return localisation.getCurrentLanguage()
    }

    fun trackLanguageAction() {
        //analytics.trackAction(AnalyticsAction.LanguageAction)
    }
}