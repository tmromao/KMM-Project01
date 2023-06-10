package com.example.kmmproject01.android.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp

/** Centralizes App text styles */
object TextStyles {
    val h0 = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = 30.sp,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val button = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = 20.sp,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
}