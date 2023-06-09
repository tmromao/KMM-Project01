package com.example.kmmproject01.resources

/** Shared resources for Android and iOS */
object Resources {
    val Image = ImageResources
    val Strings = StringResources
    val Color = ColorResources

    // Important: Since Resources is a singleton, we need to use a getter to get the current theme
    // because the theme can change during runtime
    // How to use: Resources.Theme.primaryColor.getColor()
    val Theme:Theme
        get() = Color.getTheme()

    // 1) Define material theme colors
    // 2) Define internal methods to get the current theme
    // 3) Set the colors in the theme of the app
    val Dark = Color.getDarkTheme()
    val Light = Color.getLightTheme()

    // How to use: ex. modifier = modifier.height(Spacing.extraLarge.dp)
    val Spacing = SpacingResources.getSpacing()

    val FontSizing = FontSizingResources.getFontSizing()
}