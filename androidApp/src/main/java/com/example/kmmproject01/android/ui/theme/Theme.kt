package com.example.kmmproject01.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.resources.isSystemInDarkMode

@Composable
fun AndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {

    val colors = if (darkTheme) {
        darkColors(
            primary = Resources.Dark.primary.getColor(),
            primaryVariant = Resources.Dark.primaryVariant.getColor(),
            secondary = Resources.Dark.secondary.getColor()
        )
    } else {
        lightColors(
            primary = Resources.Light.primary.getColor(),
            primaryVariant = Resources.Light.primaryVariant.getColor(),
            secondary = Resources.Light.secondary.getColor(),
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        //Aqui especificaria os meus ex.
        // h0 = TextStyles.h0,
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(4.dp)
    )

    MaterialTheme(
        colors = colors, // Colors that i have defined in the Resources file, shared on both platforms
        typography = typography,
        shapes = shapes,
        content = content
    )
}