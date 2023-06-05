package com.example.kmmproject01.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.kmmproject01.di.DI
import com.example.kmmproject01.utils.AndroidMainApp

@Composable
fun DependencyInjectionForPreview() {
    AndroidMainApp.applicationContext = LocalContext.current.applicationContext
    DI.fake()
}