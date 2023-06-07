package com.example.kmmproject01.android.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// 1) Import fonts to (resource folder font)
// 2) Create font types and put them in the material theme (FontTypes)
// 3) Create customized styles (TextStyles)
// 4) Use them in Typography (Type)
// 5) Create MaterialTheme (Theme)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    //Aqui especificaria os meus ex.
    // h0 = TextStyles.h0,
)