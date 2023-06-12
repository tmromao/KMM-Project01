package com.example.kmmproject01.android.ui.activity

import androidx.compose.foundation.background
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kmmproject01.android.ui.components.BottomSheet
import com.example.kmmproject01.android.ui.components.DummyScreen
import com.example.kmmproject01.android.ui.components.ModalBottomSheet
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalStdlibApi::class, ExperimentalMaterialApi::class)
fun ModalBottomSheetVideo() {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()
    val onBottomSheetAction = {
        coroutineScope.launch {
            if (bottomSheetState.isVisible) bottomSheetState.hide() else bottomSheetState.show()
        }
    }

    ModalBottomSheet(
        title = "Título do BottomSheet",
        sheetState = bottomSheetState,
        parentContent = {
            DummyScreen(
                modifier = Modifier.background(
                    color = Color.LightGray
                ),
                name = "Exibir BottomSheet", onClick = { onBottomSheetAction() }
            )
        }
    ) {
        Text(text = "Conteúdo do Bo ttomSheet")
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun DefaultBottomSheetVid() {

    val sheet = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Expanded)
    )
    val coroutineScope = rememberCoroutineScope()
    val onBottomSheetAction = {
        coroutineScope.launch {
            if(sheet.bottomSheetState.isExpanded){
                sheet.bottomSheetState.collapse()
            } else {
                sheet.bottomSheetState.expand()
            }
        }
    }

    BottomSheet(
        title = "Título do BottomSheet",
        scaffoldState = sheet,
        parentContent = {
            DummyScreen(
                modifier = Modifier.background(
                    color = Color.LightGray
                ),
                name = "Exibir DefaultBottomSheet", onClick = { onBottomSheetAction() }
            )
        }
    ) {
        Text(text = "Conteúdo do BottomSheet")
    }
}