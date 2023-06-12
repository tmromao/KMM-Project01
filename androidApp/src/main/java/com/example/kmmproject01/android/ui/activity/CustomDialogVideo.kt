package com.example.kmmproject01.android.ui.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.DialogTexts
import com.example.kmmproject01.android.ui.components.CustomDialog
import com.example.kmmproject01.android.ui.components.PrimaryButton
import com.example.kmmproject01.android.ui.components.Spacer

@Composable
fun CustomDialogVideo() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var showForceUpdateDialog by remember { mutableStateOf(false) }
        var showCancelDialog by remember { mutableStateOf(false) }

        Column(modifier = Modifier.padding(12.dp)) {
            if (showForceUpdateDialog) {
                CustomDialog(
                    dialogTexts = DialogTexts.ForceUpdate,
                    primaryButtonAction = { showForceUpdateDialog = false },
                    secondaryButtonAction = { showForceUpdateDialog = false }
                )
            }
            if (showCancelDialog) {
                CustomDialog(
                    dialogTexts = DialogTexts.Cancel,
                    primaryButtonAction = { showCancelDialog = false }
                )
            }
            PrimaryButton(
                text = "Atualizar App",
                onClick = {
                    showCancelDialog = false
                    showForceUpdateDialog = true
                }
            )
            Spacer.Normal()
            PrimaryButton(
                text = "Cancelar Cadastro",
                onClick = {
                    showForceUpdateDialog = false
                    showCancelDialog = true
                }
            )
        }
    }
}
