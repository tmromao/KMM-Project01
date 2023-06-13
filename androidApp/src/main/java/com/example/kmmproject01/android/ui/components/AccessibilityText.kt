package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.Spacing
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources

@Composable
fun AccessibilityText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null,
    maxLines: Int,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = style,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
    )

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun AccessibilityTextPreview() {
    DependencyInjectionForPreview()

    AndroidAppTheme {
        Column {
            Box(modifier = Modifier.width(150.dp)) {
                AccessibilityText(
                    text = "Meu titulo grande de mais que vai passar do limite",
                    style = TextStyles.h1,
                    maxLines = 1,
                )
            }
            Spacer.Normal()
            AccessibilityText(
                text = "Text Botão",
                style = TextStyles.button,
                maxLines = 1
            )
            Spacer.Normal()
            AccessibilityText(
                text = "Mini Botão",
                color = Color(0xFF124568),
                style = TextStyles.smallButton,
                maxLines = 1
            )
            Spacer.Normal()
            AccessibilityText(
                text = "Descricão",
                style = TextStyles.body2,
                color = Resources.Theme.textSecondary.getColor(),
                maxLines = 1,
            )
            Spacer.Normal()
            AccessibilityText(
                text = "Texto Paragrafo",
                style = TextStyles.body1,
                color = Resources.Theme.textPrimary.getColor(),
                maxLines = 1,
            )
            Spacer.Normal()
            AccessibilityText(
                modifier = Modifier.padding(start = Resources.Spacing.medium.dp),
                text = "AppName", //Resources.Strings.app_name.localized,
                style = TextStyles.body2,
                color = Resources.Theme.secondary.getColor(),
                maxLines = 1
            )
            Spacer.Normal()
            Box(modifier = Modifier.width(150.dp)) {
                AccessibilityText(
                    modifier = Modifier
                        .padding(
                            start = Resources.Spacing.large.dp,
                            top = 0.dp, // needed for accessibility issue max-font & max-zoom
                            bottom = Resources.Spacing.big.dp,
                            end = Resources.Spacing.large.dp
                        ),
                    text = "description bem longa que tambem vai passar do limite",
                    style = TextStyles.body2,
                    textAlign = TextAlign.Center,
                    color = Resources.Theme.textTertiary.getColor(),
                    maxLines = 3,
                )
            }
            Spacer.Normal()
            AccessibilityText(
                text = "description",
                style = TextStyles.body2,
                color = Resources.Theme.primary.getColor(),
                maxLines = Int.MAX_VALUE
            )
            Spacer.Normal()
            AccessibilityText(
                modifier = Modifier.padding(horizontal = Resources.Dimen.defaultPadding.start),
                text = "Meu Texto",
                style = TextStyles.h1,
                color = Resources.Theme.title.getColor(),
                textAlign = TextAlign.Center,
                maxLines = 1,
            )
            Spacer.Normal()
            AccessibilityText(
                modifier = Modifier.padding(horizontal = Resources.Dimen.defaultPadding.start),
                text = "Texto", //Resources.Strings.app_name.localized,
                style = TextStyles.body1,
                color = Resources.Theme.subtitle.getColor(),
                textAlign = TextAlign.Center,
                maxLines = 3,
            )
            Spacer.Normal()
            AccessibilityText(
                text = "App Name", //Resources.Strings.app_name.localized,
                style = TextStyles.h2,
                textAlign = TextAlign.Center,
                color = Resources.Theme.titleSecondary.getColor(),
                maxLines = 2
            )
            Spacer.Normal()
        }
    }
}