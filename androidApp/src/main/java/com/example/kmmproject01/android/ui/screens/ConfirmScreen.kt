package com.example.kmmproject01.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.components.PrimaryButton
import com.example.kmmproject01.android.ui.components.Spacer
import com.example.kmmproject01.android.ui.headers.NavigationHeader
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources

@Composable
fun Confirm2faScreen(
    onBack: () -> Unit,
    onClose: () -> Unit,
    onNext: () -> Unit
) {
    val screenState = ScreenState(rememberScrollState())
    BaseScreen(
        header = {
            NavigationHeader(
                screenState = screenState,
                title = "2FA Code",
                onBack = onBack,
                onClose = onClose
            )
        },
        body = {
            OtpConfirmationContent(
                scrollState = screenState.scrollState,
                onNext = onNext
            )
        }
    )
}

@Composable
fun OtpConfirmationContent(
    scrollState: ScrollState,
    onNext: (() -> Unit)? = null
) {
    val top: @Composable () -> Unit = {
        Column(
            modifier = Modifier.padding(horizontal = Resources.Dimen.screen.padding)
        ) {
            Spacer.Big()
            Text(
                text = getLoremIpsumShort(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
            Spacer.Big()
        }
    }

    val middle: @Composable () -> Unit = {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Resources.Dimen.screen.padding)
                .clip(shape = RoundedCornerShape(size = Resources.Dimen.card.cornerRadius))
                .background(color = Resources.Theme.surface.getColor())
                .padding(all = Resources.Dimen.card.padding)
        ) {
            Column {
                Text(
                    text = getLoremIpsumShort(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
                Spacer.Normal()
                if (onNext != null) {
                    PrimaryButton(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Confirmar",
                        onClick = onNext,
                    )
                }
            }
        }
    }

    val bottom: @Composable () -> Unit = {
        Column(
            modifier = Modifier.padding(horizontal = Resources.Dimen.screen.padding)
        ) {
            Spacer.Big()
            Text(
                text = getLoremIpsumLong(),
                style = TextStyles.body1,
                color = Resources.Theme.defaultTextColor.getColor()
            )
            Spacer.Big()
        }
    }

    BaseScreenContent(
        scrollState = scrollState
    ) {
        top()
        middle()
        bottom()
    }
}

@Preview(showBackground = true)
@Composable
fun Confirm2faScreenPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Confirm2faScreen({}, {}, {})
    }
}