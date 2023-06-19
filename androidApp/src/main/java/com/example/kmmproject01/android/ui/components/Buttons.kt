package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.kmmproject01.android.ui.theme.Spacing
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.utils.LoadingButtonState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun TopButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    OutlinedButton(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Composable
fun BottomButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Preview
@Composable
fun DialogButtonsPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            TopButton(text = "Botão superior")
            Spacer(modifier = Modifier.height(12.dp))
            Spacer.Big()
            //SpacerNormal()
            BottomButton(text = "Botão inferior")
        }
    }
}
// 1) COMO CRIAR UM BASE BUTTON RE-USÁVEL (EXTENDER EM COMPOSE)
// 2) COMO CRIAR BOTÃO DE LANGUAGE PICKER
// 3) COMO CRIAR BOTÃO DE NAVEGACÃO
// 4) COMO CRIAR BOTÃO COM CONTURA
// 5) COMO CRIAR BOTÃO DE FECHAR DIALOGS
@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        colors = colors,
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
    onClick: () -> Unit = {}
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
    onClick: () -> Unit = {}
) {
    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
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
fun PrimaryGrayButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    BaseButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.primary.getColor(),
            contentColor = Resources.Theme.onPrimary.getColor(),
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
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(48.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        border = BorderStroke(Resources.Spacing.extraTiny.dp, Resources.Theme.strokeSecondary.getColor()),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
            contentColor = Resources.Theme.contentSecondary.getColor(),
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
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    showBackIcon: Boolean = false
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = Resources.Spacing.normal.dp),
        modifier = modifier
            .height(34.dp)
            .defaultMinSize(minWidth = Resources.Spacing.huge.dp, minHeight = 1.dp),
        shape = RoundedCornerShape(34.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundSecondaryAlpha.getColor(),
            contentColor = Resources.Theme.contentSecondary.getColor(),
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
            style = TextStyles.smallButton,
        )
    }
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(Resources.Spacing.extraBig.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Resources.Theme.backgroundCloseButton.getColor(),
            contentColor = Resources.Theme.contentCloseButton.getColor(),
            disabledBackgroundColor = Resources.Theme.disabledBackgroundCloseButton.getColor(),
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
fun CloseIconButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Resources.Theme.backgroundCloseButton.getColor(),
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier,
        backgroundColor = backgroundColor,
        icon = Icons.Filled.Close,
        onClick = onClick
    )
}

@Composable
fun BackIconButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Resources.Theme.backgroundCloseButton.getColor(),
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier,
        backgroundColor = backgroundColor,
        icon = Icons.Filled.ArrowBack,
        onClick = onClick
    )
}

@Composable
fun PlaceholderIconButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent
) {
    IconButton(
        modifier = modifier,
        backgroundColor = backgroundColor
    )
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    backgroundColor: Color,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        modifier = modifier
            .defaultMinSize(Resources.Spacing.extraBig.dp)
            .size(Resources.Spacing.extraBig.dp),
        elevation = null,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = Resources.Theme.contentCloseButton.getColor(),
            disabledBackgroundColor = Resources.Theme.disabledBackgroundCloseButton.getColor(),
            disabledContentColor = Color.Transparent
        )
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }
}

// 1) DEFINIR DEPENDÊNCIAS DE LOTTIE
// 2) DEFINIR ESTADOS DA ANIMAçÃO DE LOADING
// 3) ESPECIFICAR CORES PARA OS ESTADOS DO BOTÃO DE LOADING
// 4) CRIAR BOTÃO DE LOADING E VER NO PREVIEW
@Composable
fun LoadingButton(
    modifier: Modifier = Modifier,
    text: String,
    loadingButtonState: StateFlow<LoadingButtonState> = MutableStateFlow(LoadingButtonState.ACTIVE),
    onLoadingFinished: () -> Unit = {},
    onLoadingStart: () -> Unit = {}
) {
    val state by loadingButtonState.collectAsState()
    val localDensity = LocalDensity.current
    var buttonWidth by remember { mutableStateOf(0.dp) }
    var memorizedWidth by remember { mutableStateOf(false) }
    Button(
        modifier = modifier.height(Resources.Dimen.button.height)
            .onGloballyPositioned { coordinates ->
                if(memorizedWidth.not()){
                    memorizedWidth = true
                    buttonWidth = with(localDensity) { coordinates.size.width.toDp()
                    }
                }},
        onClick = onLoadingClick(state, onLoadingStart),
        contentPadding = PaddingValues(horizontal = Resources.Spacing.huge.dp),
        shape = RoundedCornerShape(Resources.Dimen.button.height),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = resolveLoadingBackgroundColor(state),
            contentColor = Resources.Theme.contentPrimary.getColor(),
            disabledBackgroundColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            disabledContentColor = Color.Transparent
        )
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_lottie_loading_animation))
        val loadingAnimationState = animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)
        when(state){
            LoadingButtonState.LOADING -> {
                Column(modifier = Modifier.width(buttonWidth/1.65f)){
                    LottieAnimation(
                        composition = composition,
                        progress = { loadingAnimationState.progress },
                        contentScale = ContentScale.Fit,
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
    return when(state) {
        LoadingButtonState.ACTIVE -> onLoadingStart
        else -> {{}}
    }
}

private fun resolveLoadingBackgroundColor(state: LoadingButtonState): Color {
    // resolves the button color states while active, disabled or loading
    return when(state) {
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
            LoadingButton(loadingButtonState = loadingState, text = "Loading")
            Spacer.Normal()
            PrimaryButton(text = "Explorar App")
            Spacer.Normal()
            PrimaryWhiteButton(text = "Descobrir App")
            Spacer.Normal()
            SmallButton(text = "BR")
            Spacer.Normal()
            SmallButton(text = "IT")
            Spacer.Normal()
            SmallButton(text = "Voltar", showBackIcon = true)
            Spacer.Normal()
            SmallButton(text = "Próximo")
            Spacer.Normal()
            SecondaryButton(text = "Atendimento")
            Spacer.Normal()
            CloseButton()
            Spacer.Normal()
            CloseIconButton()
            Spacer.Normal()
            BackIconButton()
            Spacer.Normal()
            PlaceholderIconButton()
        }
    }
}

//-----------------------------/

// 1) Como criar um componente de botão reutilizável (extender em compose)
// 2) Como criar botao de language picker
// 3) Como criar botao de navegacao
// 4) Como criar botao com contura
// 5) Como criar botao de fechar dialogos
/*

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
}*/
