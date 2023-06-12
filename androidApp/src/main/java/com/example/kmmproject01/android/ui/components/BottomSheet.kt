package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// 1) COMO CRIAR UM BOTTOM SHEET PADRÃ0
// 2) COMO CIRAR UM BOTTOM SHEET MODAL
// 3) CRIAR UM DUMMY SCREEN PARA VISUALIZA-LOS
// 4) COMO USA-LOS NA PRÁTICA NA MAIN ACTIVITY

/**
 * @param offset in case the content has leading padding
 * that cannot be removed, use this offset to align the content with the title
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    title: String,
    scaffoldState: BottomSheetScaffoldState,
    parentContent: @Composable () -> Unit,
    offset: Dp = 0.dp,
    sheetContent: @Composable () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val dismiss = {
        coroutineScope.launch {
            scaffoldState.bottomSheetState.collapse()
        }
    }
    val onCloseButtonAction = { dismiss() }

    BackHandler(enabled = scaffoldState.bottomSheetState.isExpanded) { dismiss() }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetElevation = 0.dp,
        sheetContent = {
            BottomSheetContentTemplate(title, onCloseButtonAction, offset, sheetContent)
        },
        sheetPeekHeight = Resources.Spacing.large.dp,
        sheetShape = RoundedCornerShape(
            topStart = Resources.Spacing.big.dp,
            topEnd = Resources.Spacing.big.dp
        )
    ) {
        parentContent()
    }
}

/**
 * @param offset in case the content has leading padding
 * that cannot be removed, use this offset to align the content with the title
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
    title: String,
    sheetState: ModalBottomSheetState,
    parentContent: @Composable () -> Unit,
    offset: Dp = 0.dp,
    sheetContent: @Composable () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val dismiss = {
        coroutineScope.launch {
            sheetState.hide()
        }
    }

    val onCloseButtonAction = {
        dismiss()
    }

    BackHandler(enabled = sheetState.isVisible) { dismiss() }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetElevation = 0.dp,
        sheetContent = {
            BottomSheetContentTemplate(title, onCloseButtonAction, offset, sheetContent)
        },
        sheetShape = RoundedCornerShape(
            topStart = Resources.Spacing.big.dp,
            topEnd = Resources.Spacing.big.dp
        ),
        scrimColor = Resources.Theme.secondary.getColor(), // <- Atencao que é a scrimColor !???
        sheetBackgroundColor = Resources.Theme.background.getColor()
    ) {
        parentContent()
    }
}

@Composable
private fun BottomSheetContentTemplate(
    title: String,
    onCloseButtonAction: () -> Job,
    headerOffset: Dp = 0.dp,
    sheetContent: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(unbounded = false)
            .wrapContentHeight(unbounded = true)
            .padding(
                start = Resources.Spacing.large.dp - headerOffset,
                top = Resources.Spacing.large.dp,
                end = Resources.Spacing.large.dp,
                bottom = Resources.Spacing.large.dp
            )

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            BottomSheetHeader(title, headerOffset, onCloseButtonAction)
            sheetContent()
        }
    }
}

@Composable
private fun BottomSheetHeader(title: String, headerOffset: Dp, onCloseButtonAction: () -> Job) {
    Row(
        Modifier.fillMaxWidth().padding(start = headerOffset, bottom = Resources.Spacing.big.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(0.8f),
            text = title,
            style = TextStyles.h2, // <- Atencao que é outro estilo de texto
            color = Resources.Theme.textPrimary.getColor(),
            maxLines = 1,
        )
        CloseButton(onClick = { onCloseButtonAction() })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomSheetPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = BottomSheetState(BottomSheetValue.Expanded)
        )

        BottomSheet(
            title = "Título do BottomSheet",
            scaffoldState = bottomSheetScaffoldState,
            parentContent = {
                DummyScreen(
                    modifier = Modifier.background(
                        color = Color.LightGray
                    ),
                    name = "DummyScreen", onClick = { }
                )
            }
        ) {
            Text(text = "Conteúdo do BottomSheet")
        }
    }
}