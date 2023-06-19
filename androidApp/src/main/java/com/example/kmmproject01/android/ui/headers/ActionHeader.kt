package com.example.kmmproject01.android.ui.headers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.components.SmallButton
import com.example.kmmproject01.android.ui.components.Spacer
import com.example.kmmproject01.android.ui.screens.ScreenState
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources

@Composable
fun TopLevelHeader(
    modifier: Modifier = Modifier,
    screenState: ScreenState,
    title: String,
    buttons: @Composable () -> Unit = {}
) {
    HeaderOverlay(
        modifier = modifier,
        scrollBlendValue = screenState.blendValue,
        statusBarThreshold = screenState.statusBarThreshold
    ) {
        TopLevelHeaderContent(
            scrollBlendValue = screenState.blendValue,
            title = title,
            buttons = buttons
        )
    }
}

@Composable
fun TopLevelHeaderContent(
    scrollBlendValue: Float,
    title: String,
    buttons: @Composable () -> Unit,
    textStartColor: Color = Resources.Theme.textStartColor.getColor(),
    textEndColor: Color = Resources.Theme.textEndColor.getColor()
) {
    val textColor = Color(ColorUtils.blendARGB(textStartColor.toArgb(), textEndColor.toArgb(), scrollBlendValue))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = TextStyles.h2,
            color = textColor
        )
        Spacer(modifier = Modifier.weight(1f))
        buttons()
    }
}

@Preview
@Composable
fun TopLevelHeaderPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            TopLevelHeader(
                screenState = ScreenState(rememberScrollState(0)),
                title = "Olá Mario",
                buttons = {}
            )
            Spacer.Big()
            TopLevelHeader(
                screenState = ScreenState(rememberScrollState(50)),
                title = "Olá Mario",
                buttons = {}
            )
            Spacer.Big()
            TopLevelHeader(
                screenState = ScreenState(rememberScrollState(100)),
                title = "Olá Mario",
                buttons = {}
            )
        }
    }
}

@Preview
@Composable
fun TopLeveHeaderContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        val visible = 0f
        val halfVisible = 0.5f
        val invisible = 1f
        Column {
            TopLevelHeaderContent(
                scrollBlendValue = visible,
                title = "Olá Mario",
                buttons = {
                    SmallButton(text = "Login")
                    Spacer(modifier = Modifier.width(10.dp))
                    SmallButton(text = "Profile")
                }
            )
            Spacer.Big()
            TopLevelHeaderContent(
                scrollBlendValue = halfVisible,
                title = "Olá Mario",
                buttons = {
                    SmallButton(text = "Login")
                    Spacer(modifier = Modifier.width(10.dp))
                    SmallButton(text = "Profile")
                }
            )
            Spacer.Big()
            TopLevelHeaderContent(
                scrollBlendValue = invisible,
                title = "Olá Mario",
                buttons = {
                    SmallButton(text = "Login")
                    Spacer(modifier = Modifier.width(10.dp))
                    SmallButton(text = "Profile")
                }
            )
        }
    }
}