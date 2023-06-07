package com.example.kmmproject01.resources

/** Shared resources for Android and iOS */
object Resources {
    val Image = ImageResources
    val Strings = StringResources
    val Color = ColorResources

    val Theme:Theme
        get() = Color.getTheme()
}