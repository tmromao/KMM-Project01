package com.example.kmmproject01.resources

import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

actual fun getWindowSize(): WindowSize {
    if (UIScreen.mainScreen.scale < 3.0) return WindowSize.Small
    val width = UIScreen.mainScreen.bounds.useContents {// Foi super tricky achar essa função!
        this.size.width
    }
    return if(width < 400.0) WindowSize.Medium else WindowSize.Large
}

actual class SpacingResource actual constructor(private val unit: Int) {
    private val scale = UIScreen.mainScreen.scale

    val pt: Double by lazy { pt() }
    private fun pt():Double {
        return unit.toDouble() * scale
    }
}