package com.example.kmmproject01.android.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kmmproject01.resources.Resources

//1) How to customize Spacers
// 2) How to use shared spacers
// 3) Different ways to customize spacers
object Spacer {

    @Composable
    fun Tiny() {
        Spacer(modifier = Modifier.height(Resources.Spacing.tiny.dp))
    }

    @Composable
    fun ExtraSmall() {
        Spacer(modifier = Modifier.height(Resources.Spacing.extraSmall.dp))
    }

    @Composable
    fun Small() {
        Spacer(modifier = Modifier.height(Resources.Spacing.small.dp))
    }

    @Composable
    fun Normal() {
        Spacer(modifier = Modifier.height(Resources.Spacing.normal.dp))
    }

    @Composable
    fun Medium() {
        Spacer(modifier = Modifier.height(Resources.Spacing.medium.dp))
    }

    @Composable
    fun Big() {
        Spacer(modifier = Modifier.height(Resources.Spacing.big.dp))
    }

    @Composable
    fun Large() {
        Spacer(modifier = Modifier.height(Resources.Spacing.large.dp))
    }

    @Composable
    fun ExtraLarge() {
        Spacer(modifier = Modifier.height(Resources.Spacing.extraLarge.dp))
    }

    @Composable
    fun Huge() {
        Spacer(modifier = Modifier.height(Resources.Spacing.huge.dp))
    }


}