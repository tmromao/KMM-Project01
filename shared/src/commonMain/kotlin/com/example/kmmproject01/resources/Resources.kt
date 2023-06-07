package com.example.kmmproject01.resources

/** Shared resources for Android and iOS */
object Resources {
    val Image = ImageResources
    val Strings = StringResources
    val Color = ColorResources

    val Theme:Theme
        get() = Color.getTheme()

    // How to use: ex. modifier = modifier.height(Spacing.extraLarge.dp)
    val Spacing = SpacingResources.getSpacing()
}