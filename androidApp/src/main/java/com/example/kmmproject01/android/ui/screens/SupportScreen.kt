package com.example.kmmproject01.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavHostController
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.components.PrimaryButton
import com.example.kmmproject01.android.ui.components.Spacer
import com.example.kmmproject01.android.ui.headers.TopLevelHeader
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources


@Composable
fun SupportScreen(
    navController: NavHostController
) {
    SupportScreen(
        onSupportClick = { }
    )
}

@Composable
fun SupportScreen(
    onSupportClick: () -> Unit
) {
    val screenState = ScreenState(rememberScrollState())

    BaseScreen(
        header = {
            TopLevelHeader(
                screenState = screenState,
                title = "Suporte"
            )
        },
        body = {
            SupportContent(
                scrollState = screenState.scrollState,
                onSupportClick = onSupportClick
            )
        }
    )
}

@Composable
fun SupportContent(
    scrollState: ScrollState,
    onSupportClick: () -> Unit
) {
    BaseScreenContent(
        scrollState = scrollState,
        middleContent = {
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
                }
            }
        },
        bottomContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Resources.Dimen.screen.padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer.Big()
                PrimaryButton(text = "Support", onClick = onSupportClick)
                Spacer.Big()
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun SupportScreenPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        SupportScreen {}
    }
}