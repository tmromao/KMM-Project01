package com.example.kmmproject01.resources

// 1) Add dependencies
// 2) Define expected and actual classes
// 3) Implement the expected class in Android and iOS
// 4) Implement ColorResources
// 5) Implement in Resources
/**
 * Indicates whether the app is using dark mode or not
 *
 * */
expect fun isSystemInDarkMode(): Boolean

/**
 * iOC can only handle RGB-values to create its color instances. That's why we offered the abstract  class
 * It is intended to be used by iOS only.
 * Android on the other hand must resolve the color from the resources. For that reason
 * we offer a color resolver method for android only in its actual implementation.
 *
 * */
expect class ColorResource(colorHexValue: Long) : IosColor

/**
 *
 * iOS can only handle RGB-values to create its color instances,
 * while Android needs an HEX value.
 * That's why we need to extend from [IosColor].
 * We pass value over to IosColor which takes an HEX-Value and extracts its
 * RGB values making it available for iOS.
 *
 * */
abstract class IosColor(colorHexValue: Long) {
    var r = 0.0
    var g = 0.0
    var b = 0.0
    var a = 0.0

    init {
        a = ((colorHexValue shr 24) and 0xFF).toDouble() / 255.0
        r = ((colorHexValue shr 16) and 0xFF).toDouble() / 255.0
        g = ((colorHexValue shr 8) and 0xFF).toDouble() / 255.0
        b = ((colorHexValue shr 0) and 0xFF).toDouble() / 255.0
    }
}
