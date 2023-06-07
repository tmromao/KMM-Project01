package com.example.kmmproject01.resources

import kotlin.native.concurrent.ThreadLocal


@ThreadLocal
object ColorResources {
    fun getTheme(): Theme = if (isSystemInDarkMode()) Theme.Dark else Theme.Light
}

abstract class Theme(
    // Default theming colors for background and content
    val contentPrimary: ColorResource,
    val contentSecondary: ColorResource,
    val backgroundPrimary: ColorResource,
    val backgroundSecondary: ColorResource,
    val backgroundSecondaryAlpha: ColorResource,
    val divider: ColorResource,
    val textPrimary: ColorResource,
    val textSecondary: ColorResource,
    val textTertiary: ColorResource,
    val iconPrimary: ColorResource,
    val iconSecondary: ColorResource,

    // Default theming colors for buttons
    val strokeSecondary: ColorResource,
    val contentCloseButton: ColorResource,
    val backgroundCloseButton: ColorResource,
    val disabledBackgroundCloseButton: ColorResource,

    // further content and background with index
    val content1: ColorResource,
    val background1: ColorResource,

    // default text theming colors
    val title: ColorResource,
    val titleSecondary: ColorResource,
    val subtitle: ColorResource,
    val description: ColorResource,
) {
    object Dark : Theme(
        contentPrimary = ColorResource(0xFFFFFFFF),//white
        contentSecondary = ColorResource(0xFF131313),//black
        backgroundPrimary = ColorResource(0xFF414141),//black
        backgroundSecondary = ColorResource(0xFF707070),//black
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF),//black
        strokeSecondary = ColorResource(0xFF131313),//black
        divider = ColorResource(0xFFFFFFFF),//white
        textPrimary = ColorResource(0xFFFFFFFF),//white
        textSecondary = ColorResource(0xFFBDBDBD),//white
        textTertiary = ColorResource(0xFF707070),//black
        iconPrimary = ColorResource(0xFFFFFFFF),//white
        iconSecondary = ColorResource(0xFFBDBDBD),//white

        contentCloseButton = ColorResource(0xFFFFFFFF),//white
        backgroundCloseButton = ColorResource(0xFF131313),//black
        disabledBackgroundCloseButton = ColorResource(0xFF707070), //black

        content1 = ColorResource(0xFFFFFFFF),//white
        background1 = ColorResource(0xFFFFFFFF),//White
        title = ColorResource(0xFFFFFFFF),//white
        titleSecondary = ColorResource(0xFFBDBDBD),//white
        subtitle = ColorResource(0xFFBDBDBD),//white
        description = ColorResource(0xFFBDBDBD),//white
    )

    object Light : Theme(
        contentPrimary = ColorResource(0xFFFFFFFF),//white
        contentSecondary = ColorResource(0xFFE95D0F),//Orange
        backgroundPrimary = ColorResource(0xFFE95D0F),//Orange
        backgroundSecondary = ColorResource(0xFFFFFFFF),//White
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF),//black
        strokeSecondary = ColorResource(0xFF131313),//black
        divider = ColorResource(0xFFE95D0F),//Orange
        textPrimary = ColorResource(0xFFE95D0F),//Orange
        textSecondary = ColorResource(0xFFE95D0F),//Orange
        textTertiary = ColorResource(0xFF707070),//black
        iconPrimary = ColorResource(0xFFE95D0F),//Orange
        iconSecondary = ColorResource(0xFFE95D0F),//Orange

        contentCloseButton = ColorResource(0xFFE95D0F),//Orange
        backgroundCloseButton = ColorResource(0xFF131313), //black
        disabledBackgroundCloseButton = ColorResource(0xFF707070), //black

        content1 = ColorResource(0xFFE95D0F),//Orange
        background1 = ColorResource(0xFFE95D0F),//Orange
        title = ColorResource(0xFFE95D0F),//Orange
        titleSecondary = ColorResource(0xFFE95D0F),//Orange
        subtitle = ColorResource(0xFFE95D0F),//Orange
        description = ColorResource(0xFFE95D0F),//Orange
    )
}