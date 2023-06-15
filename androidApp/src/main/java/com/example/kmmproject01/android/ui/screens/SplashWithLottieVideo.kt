package com.example.kmmproject01.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.kmmproject01.android.ui.components.DummyScreen
import com.example.kmmproject01.android.ui.components.ModalBottomSheet
import kotlinx.coroutines.launch

@Composable
fun SplashWithLottieVid() {
    AnimationScreen(navController = rememberNavController())
}
@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun ModalBottomSheetVid() {
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
        Text(text = "Conteúdo do BottomSheet")
    }
}