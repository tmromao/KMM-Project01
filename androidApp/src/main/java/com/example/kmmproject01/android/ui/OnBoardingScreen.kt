package com.example.kmmproject01.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.MyApplicationTheme
import com.example.kmmproject01.android.R
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.viewmodels.OnBoardingImages
import com.example.kmmproject01.viewmodels.OnBoardingViewModel
import com.example.kmmproject01.resources.getPreviewImageResource
import com.example.kmmproject01.resources.getTextResource
import com.example.kmmproject01.viewmodels.OnBoardingTexts

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel,
) {
    AndroidAppTheme {
        Surface {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(state = rememberScrollState())
                        .weight(weight = 1f, fill = true)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = viewModel.images.topImage.id),
                        contentDescription = "TopImage",
                    )
                    // Dimensao compartilhada
                    Spacer(modifier = Modifier.height(Resources.Dimen.button.height))
                    //Text(text = viewModel.texts.topImageText)
                    Text("Eu consigo...")
                    Image(
                        painter = painterResource(id = viewModel.images.middleImage.id),
                        contentDescription = "MiddleImage",
                    )
                    Text("Eu consigo...")
                    Image(
                        painter = painterResource(id = viewModel.images.bottomImage.id),
                        contentDescription = "BottomImage",
                    )
                    Text("renderizar imagens")
                }
            }
        }
    }

}

@Preview
@Composable
fun OnBoardingPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            OnBoardingScreen(
                viewModel = OnBoardingViewModel(
                    images = OnBoardingImages(
                        topImage = getPreviewImageResource(id = R.drawable.ic_warning),
                        middleImage = getPreviewImageResource(id = R.drawable.ic_warning),
                        bottomImage = getPreviewImageResource(id = R.drawable.ic_warning)
                    ),
                    texts = OnBoardingTexts(
                        topImageText = getTextResource("TopImageText"),
                        middleImageText = getTextResource("MiddleImageText"),
                        bottomImageText = getTextResource("BottomImageText")
                    )
                )
            )
        }
    }
}


