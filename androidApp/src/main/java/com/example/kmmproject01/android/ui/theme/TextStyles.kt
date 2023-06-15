package com.example.kmmproject01.android.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.example.kmmproject01.resources.Resources

/** Centralizes App text styles */
object TextStyles {
    val h0 = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.big.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val h1 = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.normal.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val h2 = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.normal.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val body1 = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.normal.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val body2 = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.normal.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )

    val button = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = 20.sp,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val smallButton = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = 20.sp,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val textField = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.medium.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
    val textFieldHint = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = Resources.FontSizing.small.size,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )

    val navBarItem = TextStyle(
        fontFamily = FontTypes.ttOpenSansCondensedRegular.toFontFamily(),
        fontWeight = FontTypes.ttOpenSansCondensedRegular.weight,
        fontSize = 13.sp,
        fontStyle = FontTypes.ttOpenSansCondensedRegular.style
    )
}