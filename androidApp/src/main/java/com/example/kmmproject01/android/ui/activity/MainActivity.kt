package com.example.kmmproject01.android.ui.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.kmmproject01.android.MyApplicationTheme
import com.example.kmmproject01.android.ui.screens.NavigationVideo
import com.example.kmmproject01.android.ui.screens.SplashWithLottieVid
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.di.DI
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.utils.AndroidMainApp
import com.example.kmmproject01.viewmodels.EntryViewModel
import com.example.kmmproject01.viewmodels.MainActivityViewModel

class MainActivity : ComponentActivity() {

    // ViewModel para enderecar auditoria de seguranca
    private val model by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Endereca auditoria de seguranca: Hide recent thumbnails
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            // Endereca auditoria de seguranca: Hide Multi-Windows Mode
            model.toggleHideThumbnailState(
                hide = isInMultiWindowMode || isInPictureInPictureMode
            )
        }

        val entryViewModel = EntryViewModel()
        Log.d("TESTANDO", DI.Native.environment.name)

        setContent {

            // Escutar, observar o estado de "hideThumbnailState" e atualizar a UI
            val hideThumbnail by model.hideThumbnail.collectAsState()

            AndroidAppTheme {
                Box(modifier = Modifier.navigationBarsPadding()){ // navigationBarsPadding() para evitar que o conteudo fique por baixo da barra de navegacao
                    if (hideThumbnail) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Resources.Theme.background.getColor())
                        )
                    } else{

                        // KtorVid(viewModel = entryViewModel)
                        //CustomDialogVideo()
                        //ModalBottomSheetVideo()
                        //SplashWithLottieVid()
                        NavigationVideo()
                    }
                }

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
