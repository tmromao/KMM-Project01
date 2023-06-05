package com.example.kmmproject01.viewmodels

import com.example.kmmproject01.BaseSharedViewModel
import com.example.kmmproject01.di.DI.inject
import com.example.kmmproject01.network.Environment
import com.example.kmmproject01.resources.ImageResource
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.utils.CommonLoggerImpl

// 1) Implementar iOS e Android
// 2) Define a shared resources class
// 3) Create the viewModel
// 4) Exemplify the preview
class OnBoardingViewModel(
    val images: OnBoardingImages, //  Pitfall nr1. kmm para ios não sabe lidar com default values (yet)
) : BaseSharedViewModel() {

    private val environment by inject<Environment>()

    init {
        CommonLoggerImpl().log("Meu ambiente é: ${environment.name}")
    }
    constructor() : this(
        images = OnBoardingImages()
    )
}

// Para fins didáticos aqui, mas poderia ser um arquivo separado

data class OnBoardingImages(
    val topImage: ImageResource,
    val middleImage: ImageResource,
    val bottomImage: ImageResource,
) {
    constructor() : this(
        topImage = Resources.Image.fire,
        middleImage = Resources.Image.lamp,
        bottomImage = Resources.Image.switch
    )
}