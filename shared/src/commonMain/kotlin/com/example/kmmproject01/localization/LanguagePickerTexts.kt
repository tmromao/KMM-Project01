package com.example.kmmproject01.localization

import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.resources.TextResource

data class LanguagePickerTexts(
    val title: TextResource,
    val languageOptions: List<Language>,
) {
    constructor() : this(
        title = Resources.Strings.app_language,
        languageOptions = Language.getLanguages()
    )
}