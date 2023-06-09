package com.example.kmmproject01.resources

actual class FontSizingResource actual constructor(
    private val fontSize: Int,
    private val fontLineHeight: Int,
) {
    val size: Double by lazy { fontSize.toDouble() }
    val lineHeight: Double by lazy { fontLineHeight.toDouble() / 100.0 }

}