package com.example.kmmproject01.resources

import platform.UIKit.UIColor
import platform.UIKit.UITraitCollection
import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.currentTraitCollection

actual fun isSystemInDarkMode(): Boolean {
    val mode = UITraitCollection.currentTraitCollection.userInterfaceStyle()
    return mode == UIUserInterfaceStyle.UIUserInterfaceStyleDark
    return false
}

/**
 *
 * iOS works only with RGB-values while Android needs an HEX value.
 * That's why we need to extend from [IosColor].
 * We pass value over to IosColor which takes an HEX-Value and extracts its
 * RGB values making it available for iOS.
 *
 * */
actual class ColorResource actual constructor(colorHexValue: Long) : IosColor(colorHexValue) {
    fun getColor() = UIColor(red = r, green = g, blue = b, alpha = a
}