package com.example.kmmproject01.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kmmproject01.viewmodels.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel,
) {
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
                Text("Hello Compose")
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