package com.example.kmmproject01.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.kmmproject01.android.R

/** Centralizes app fonts, so we do not have to change each font manually in the whole app*/
object FontTypes {
    val ttOpenSansCondensedRegular: Font = Font(
        resId = R.font.opensans_condensed_regular,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    )
}

val LocalFonts = compositionLocalOf { FontTypes }

/** Makes fonts available in app's theme like MaterialTheme.typography */
val MaterialTheme.fonts: FontTypes
    @Composable
    @ReadOnlyComposable
    get() = LocalFonts.current