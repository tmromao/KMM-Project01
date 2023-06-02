package com.example.kmmproject01.android.ui.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.viewmodels.EntryViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun KtorVid(viewModel: EntryViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val entries by viewModel.entries.collectAsState()
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Ktor KMM",
                style = LocalTextStyle.current.copy(
                    fontSize = TextUnit(24f, TextUnitType.Sp)
                )
            )
            Row {
                Button(onClick = { viewModel.fetchEntries() }) {
                    Text(text = "Fetch Entries")
                }
            }
            entries?.forEach { entry ->
                Text(text = entry.description ?: "")
            }
        }
    }

}