package com.example.kmmproject01.android.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.android.MyApplicationTheme
import com.example.kmmproject01.utils.AndroidApplication
import com.example.kmmproject01.viewmodels.EntryViewModel
import com.example.kmmproject01.viewmodels.SampleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val entryViewModel = EntryViewModel()
        Log.d("TESTANDO", AndroidApplication.environment.name)

        setContent {
            MyApplicationTheme {
                KtorVid(viewModel = entryViewModel)
            }
        }
    }
}

/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = SampleViewModel()
        Log.d("TESTANDO", AndroidApplication.environment.name)

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val stories by viewModel.stories.collectAsState()

                    Column(modifier = Modifier.padding(12.dp)) {

                        Text(text = "SqlDelight KMM", style = MaterialTheme.typography.h4)

                        Row {
                            Button(onClick = { viewModel.loadStories() }) {
                                Text(text = "Load Stories")
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(onClick = { viewModel.clearStories() }) {
                                Text(text = "Clear Stories")
                            }
                        }

                        stories.forEach { story ->
                            Text(text = story.name)
                        }
                    }
                }
            }
        }
    }
}*/


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
