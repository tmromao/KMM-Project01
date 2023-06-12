package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kmmproject01.DialogTexts
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources

// 1) Como criar um alert dialog customizado, compartilhando texto (Dialog texts)
// 2) Atualizar StringResources, string.xml, DimensResource, ColorResource
// 3) Criar caixinhas de alerta, custom dialogs ou popups
// 4) Como usar na prática na main activity
@Composable
fun CustomDialog(
    dialogTexts: DialogTexts,
    primaryButtonAction: () -> Unit,
    secondaryButtonAction: (() -> Unit)? = null,
) {
    CustomDialog(
        title = "Texto", // deveria ser com localized library
        description = "Descricao", // deveria ser com localized library
        primaryText = "Primary", // deveria ser com localized library
        primaryAction = primaryButtonAction,
        secondaryText = "Secondary" ?: "", // deveria ser com localized library
        secondaryAction = secondaryButtonAction,
    )

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(
    title: String,
    description: String,
    primaryText: String,
    primaryAction: () -> Unit,
    secondaryText: String? = null,
    secondaryAction: (() -> Unit)? = null
) {

    Dialog(
        onDismissRequest = { primaryAction() },
        properties = DialogProperties(
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(
            shape = RoundedCornerShape(Resources.Dimen.surface.roundedCorner),
            color = Resources.Theme.surface.getColor(),
            modifier = Modifier.fillMaxWidth(0.88f)
        ) {
            Column(
                modifier = Modifier.padding(
                    start = Resources.Spacing.big.dp,
                    top = Resources.Spacing.medium.dp + Resources.Spacing.extraTiny.dp,
                    end = Resources.Spacing.big.dp,
                    bottom = Resources.Spacing.big.dp
                )
            ) {

                Text(
                    text = title,
                    style = TextStyles.h2,
                    color = Resources.Theme.textPrimary.getColor(),
                    maxLines = 2
                )

                Spacer.Small()

                Text(
                    text = description,
                    style = TextStyles.textField,
                    color = Resources.Theme.textPrimary.getColor(),
                    maxLines = Int.MAX_VALUE
                )

                Spacer.Big()

                PrimaryButton(
                    text = primaryText,
                    onClick = { primaryAction()},
                    modifier = Modifier.fillMaxWidth()
                )

                if (secondaryText != null && secondaryAction != null) {
                    Spacer.Normal()

                    PrimaryButton( // <- Aqui posso substituir por um GrayButton
                        text = secondaryText,
                        onClick = { secondaryAction() },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }


        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SingleActionDialogPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        CustomDialog(
            title = "Atualizar App",
            description = "Para continar usando o app, você precisa atualiza-lo.",
            primaryText = "Atualizar",
            primaryAction = { }
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DoubleActionDialogPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        CustomDialog(
            title = "Cadastro",
            description = "Voce tem certeza que deseja cancelar o cadastro?",
            primaryText = "Cancelar",
            primaryAction = { },
            secondaryText = "Continuar",
            secondaryAction = { }
        )
    }
}