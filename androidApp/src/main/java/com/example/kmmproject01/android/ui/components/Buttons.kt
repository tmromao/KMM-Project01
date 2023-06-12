package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.R
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.utils.LoadingButtonState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// 1) Como criar um componente de botão reutilizável (extender em compose)
// 2) Como criar botao de language picker
// 3) Como criar botao de navegacao
// 4) Como criar botao com contura
// 5) Como criar botao de fechar dialogos

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {

    Button(
        modifier = modifier.height(48.dp),
        colors = colors,
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(48.dp),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        content()
    }

}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {

    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundPrimary.getColor(),
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = TextStyles.button
        )
    }
}

@Composable
fun PrimaryWhiteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {

    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundPrimary.getColor(),
            contentColor = Resources.Theme.content1.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
            style = TextStyles.button
        )
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {

    OutlinedButton(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(48.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        border = BorderStroke(Resources.Spacing.tiny.dp, Resources.Theme.contentPrimary.getColor()),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )

    ) {
        Text(text = text, style = TextStyles.button)
    }
}

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    showBackIcon: Boolean = false,
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.normal.dp),
        modifier = modifier
            .height(32.dp)
            .defaultMinSize(minWidth = Resources.Spacing.huge.dp, minHeight = 1.dp),
        shape = RoundedCornerShape(34.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundPrimary.getColor(),
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        if (showBackIcon) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIos,
                contentDescription = null,
                tint = Resources.Theme.contentCloseButton.getColor(),
                modifier = Modifier
                    .padding(end = Resources.Spacing.tiny.dp)
                    .size(Resources.Spacing.normal.dp)
            )
        }
        Text(
            text = text,
            color = Resources.Theme.contentCloseButton.getColor(),
            style = TextStyles.button
        )
    }
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(Resources.Spacing.extraBig.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundPrimary.getColor(),
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}

@Composable
fun LoadingButton(
    modifier: Modifier = Modifier,
    text: String,
    loadingButtonState: StateFlow<LoadingButtonState> = MutableStateFlow(LoadingButtonState.ACTIVE),
    onLoadingFinished: () -> Unit = {},
    onLoadingStart: () -> Unit = {},
) {

    val state by loadingButtonState.collectAsState()
    val localDensity = LocalDensity.current
    var buttonWidth by remember { mutableStateOf(0.dp) }
    var memorizedWidth by remember { mutableStateOf(false) }

    Button(
        modifier = modifier
            .height(Resources.Dimen.button.height)
            .onGloballyPositioned { coordinates ->
                if (memorizedWidth.not()) {
                    memorizedWidth = true
                    buttonWidth = with(localDensity) { coordinates.size.width.toDp() }
                }
            },
        onClick = onLoadingClick(state, onLoadingStart),
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(Resources.Dimen.button.height),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = resolveLoadingBackgroundColor(state),
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        ),
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_lottie_loading_animation))
        val loadingAnimationState = animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)
        when (state) {
            LoadingButtonState.LOADING -> {
                Column(modifier = Modifier.width(buttonWidth / 1.65f)) {
                    LottieAnimation(
                        composition = composition,
                        progress = { loadingAnimationState.progress },
                        contentScale = ContentScale.Fit
                    )
                }
            }

            LoadingButtonState.FINISHED -> onLoadingFinished()
            else -> {
                Text(text = text, style = TextStyles.button)
            }
        }
    }

}

private fun onLoadingClick(state: LoadingButtonState, onLoadingStart: () -> Unit): () -> Unit {
    // prevents multiple clicks (requests) while already started, disabled or loading
    return when (state) {
        LoadingButtonState.ACTIVE -> onLoadingStart
        else -> {
            {}
        }
    }
}

private fun resolveLoadingBackgroundColor(state: LoadingButtonState): Color {
    // resolves the button color states while active, disabled or loading
    return when (state) {
        LoadingButtonState.LOADING -> Resources.Theme.loadingButtonLoadingColor.getColor()
        LoadingButtonState.DISABLED -> Resources.Theme.loadingButtonDisabledColor.getColor()
        else -> Resources.Theme.loadingButtonActiveColor.getColor()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ButtonsPreview() {
    DependencyInjectionForPreview()

    val activeState = MutableStateFlow(LoadingButtonState.ACTIVE)
    val disabledState = MutableStateFlow(LoadingButtonState.DISABLED)
    val loadingState = MutableStateFlow(LoadingButtonState.LOADING)

    AndroidAppTheme {
        Column {
            LoadingButton(loadingButtonState = activeState, text = "Registrar")
            Spacer.Normal()
            LoadingButton(loadingButtonState = disabledState, text = "Registrar")
            Spacer.Normal()
            LoadingButton(loadingButtonState = loadingState, text = "Loading...")
            Spacer.Normal()
            PrimaryButton(text = "Primary Button", onClick = {})
            Spacer.Normal()
            PrimaryWhiteButton(text = "Primary White Button", onClick = {})
            Spacer.Normal()
        }
    }
}