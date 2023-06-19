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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.components.Spacer
import com.example.kmmproject01.android.ui.headers.NavigationHeader
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources


@Composable
fun ProfileScreen(
    navController: NavController
){
    ProfileScreen(
        onBack = { navController.popBackStack() },
    )
}

@Composable
fun ProfileScreen(
    onBack: () -> Unit
){
    val screenState = ScreenState(rememberScrollState())
    BaseScreen(
        header = {
            NavigationHeader(
                screenState = screenState,
                title = "Perfil",
                onBack = onBack
            )
        },
        body = {
            ProfileContent(
                scrollState = screenState.scrollState
            )
        }
    )
}

@Composable
fun ProfileContent(
    scrollState: ScrollState
) {
    BaseScreenContent(
        scrollState = scrollState,
        topContent = {
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = Resources.Dimen.screen.padding)
            ) {
                Text(
                    text = getLoremIpsumShort(),
                    style = TextStyles.body1,
                    color = Resources.Theme.onPrimary.getColor()
                )
                Spacer.Big()
            }
        },
        middleContent = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Resources.Dimen.screen.padding)
                    .clip(shape = RoundedCornerShape(size = Resources.Dimen.card.cornerRadius))
                    .background(color = Resources.Theme.surface.getColor())
                    .padding(all = Resources.Dimen.card.padding)
            ) {
                Text(
                    text = getLoremIpsumShort(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
            }
        },
        bottomContent = {
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = Resources.Dimen.screen.padding)
            ) {
                Spacer.Big()
                Text(
                    text = getLoremIpsumMedium(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
                Spacer.Big()
                Text(
                    text = getLoremIpsumMedium(),
                    style = TextStyles.body1,
                    color = Resources.Theme.defaultTextColor.getColor()
                )
            }
        }
    )
}

/*fun getLoremIpsumMedium(): String {
    return "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
}*/

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        ProfileScreen {}
    }
}