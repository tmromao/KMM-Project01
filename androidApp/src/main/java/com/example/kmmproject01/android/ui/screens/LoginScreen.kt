package com.example.kmmproject01.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.components.PrimaryButton
import com.example.kmmproject01.android.ui.components.Spacer
import com.example.kmmproject01.android.ui.headers.NavigationHeader
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources

@Composable
fun LoginScreen(
    onClose: () -> Unit,
    onNext: () -> Unit
) {
    val screenScrollState = ScreenState(rememberScrollState())
    BaseScreen(
        header = {
            NavigationHeader(
                screenState = screenScrollState,
                title = "Fazer Login",
                onBack = null,
                onClose = onClose
            )
        },
        body = {
            LoginContent(
                scrollState = screenScrollState.scrollState,
                onNext = onNext
            )
        }
    )
}


@Composable
fun LoginContent(
    scrollState: ScrollState,
    onNext: (() -> Unit)? = null
) {
    BaseScreenContent(
        scrollState = scrollState
    ) {
        Column(
            modifier = Modifier.padding(horizontal = Resources.Dimen.screen.padding)
        ) {
            Spacer.Big()
            Text(
                text = getLoremIpsumMedium(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
            Spacer.Big()
            if (onNext != null) {
                PrimaryButton(
                    modifier = Modifier.align(CenterHorizontally),
                    text = "Login",
                    onClick = onNext,
                )
            }
            Spacer.Big()
            Text(
                text = getLoremIpsumLong(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
        }
    }
}
fun getLoremIpsumMedium(): String {
    return "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
}

@Preview
@Composable
fun LoginContentPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        LoginScreen({}, {})
    }
}