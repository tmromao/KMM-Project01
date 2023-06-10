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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources

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

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ButtonsPreview(){
    DependencyInjectionForPreview()

    AndroidAppTheme {
        Column{
            PrimaryButton(text = "Primary Button", onClick = {})
            Spacer.Normal()
            PrimaryWhiteButton(text = "Primary White Button", onClick = {})
            Spacer.Normal()
        }
    }
}