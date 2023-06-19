package com.example.kmmproject01.resources

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ColorResources {
    internal fun getTheme() = Themes // = if (isSystemInDarkMode()) Theme.Dark else Theme.Light
   // internal fun getDarkTheme(): Theme = Theme.Dark
   // internal fun getLightTheme(): Theme = Theme.Light
}
object Themes {
    val transparent by lazy { ColorResource(light = ColorScheme.transparent, dark = ColorScheme.transparent) }

    val primary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.blueLight) }
    val primaryVariant by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.blueLight) }
    val secondary by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val secondaryVariant by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }

    val background by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val surface by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.gray60a) }
    val error by lazy { ColorResource(light = ColorScheme.blue60a, dark = ColorScheme.blue60a) }
    val onPrimary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val onSecondary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val onBackground by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val onSurface by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val onError by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }

    val iconConnectivityOnline by lazy { ColorResource(light = ColorScheme.greenDark, dark = ColorScheme.greenDark) }
    val iconConnectivityOffline by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white0a) }
    val textConnectivityOnline by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val textConnectivityOffline by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val bgConnectivityOnline by lazy { ColorResource(light = ColorScheme.greenLight, dark = ColorScheme.greenLight) }
    val bgConnectivityOffline by lazy { ColorResource(light = ColorScheme.redDark, dark = ColorScheme.redDark) }
    val textFieldHintColor by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val textFieldCursorColor by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.black) }
    val textFieldSelectedFocusColor by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val textFieldUnselectedFocusColor by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.gray60a) }
    val loadingButtonActiveColor by lazy { ColorResource(light = ColorScheme.orangeDark, dark = ColorScheme.orangeDark) }
    val loadingButtonLoadingColor by lazy { ColorResource(light = ColorScheme.orangeLight, dark = ColorScheme.orangeLight) }
    val loadingButtonDisabledColor by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }

    val contentPrimary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val contentSecondary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val backgroundPrimary by lazy { ColorResource(light = ColorScheme.blueSky, dark = ColorScheme.blue) }
    val backgroundSecondary by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.gray60a) }
    val backgroundSecondaryAlpha by lazy { ColorResource(light = ColorScheme.white40a, dark = ColorScheme.white40a) }
    val strokeSecondary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val divider by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.white) }
    val textPrimary by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.white) }
    val textSecondary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val textTertiary by lazy { ColorResource(light = ColorScheme.gray60a, dark = ColorScheme.black) }
    val iconPrimary by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.black) }
    val iconSecondary by lazy { ColorResource(light = ColorScheme.blue60a, dark = ColorScheme.black60a) }
    val content1 by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.white) }
    val background1 by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.blueLight) }
    val title by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.black) }
    val titleSecondary by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.white) }
    val subtitle by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.black) }
    val description by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.blueLight) }
    val contentCloseButton by lazy { ColorResource(light = ColorScheme.blue, dark = ColorScheme.white) }
    val backgroundCloseButton by lazy { ColorResource(light = ColorScheme.grayLaminate, dark = ColorScheme.blueLight) }
    val disabledBackgroundCloseButton by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }
    val scrimColor by lazy { ColorResource(light = ColorScheme.transparent, dark = ColorScheme.gray60a) }

    val selectedContentColor by lazy { ColorResource(light = ColorScheme.blueSky, dark = ColorScheme.blueSky) }
    val unselectedContentColor by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }

    val bgOverlayHeaderDefault by lazy { ColorResource(light = ColorScheme.white0a, dark = ColorScheme.white0a) }
    val bgOverlayHeaderScroll by lazy { ColorResource(light = ColorScheme.blueCloudy, dark = ColorScheme.blueCloudy) }
    val textStartColor by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val textEndColor by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }
    val btnBgWhiteAlpha by lazy { ColorResource(light = ColorScheme.white, dark = ColorScheme.white) }
    val btnBgGrayAlpha by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val defaultTextColor by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }

    val langTextColorSelected by lazy { ColorResource(light = ColorScheme.black, dark = ColorScheme.orangeDark) }
    val langTextColorUnselected by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black) }
    val langRadioColorSelected by lazy { ColorResource(light = ColorScheme.blueLight, dark = ColorScheme.orangeDark) }
    val langRadioColorUnselected by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.orangeLight) }
    val langRadioColorDisabled by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.orangeLight) }

    val labelDisabled by lazy { ColorResource(light = ColorScheme.black5a, dark = ColorScheme.black5a) }
    val labelDefault by lazy { ColorResource(light = ColorScheme.black60a, dark = ColorScheme.black60a) }
    val labelInteractive by lazy { ColorResource(light = ColorScheme.gold, dark = ColorScheme.blueLight) }
}

/*
abstract class Theme (
    // material theme android colors
    val primary : ColorResource,
    val primaryVariant : ColorResource,
    val secondary : ColorResource,
    val secondaryVariant : ColorResource,
    val background : ColorResource,
    val surface : ColorResource,
    val error : ColorResource,
    val onPrimary : ColorResource,
    val onSecondary : ColorResource,
    val onBackground : ColorResource,
    val onSurface : ColorResource,
    val onError : ColorResource,

    // default theming colors for background and content
    val contentPrimary: ColorResource,
    val contentSecondary: ColorResource,
    val backgroundPrimary: ColorResource,
    val backgroundSecondary: ColorResource,
    val backgroundSecondaryAlpha: ColorResource,
    val divider: ColorResource,
    val textPrimary: ColorResource,
    val textTertiary: ColorResource,
    val textSecondary: ColorResource,
    val iconPrimary: ColorResource,
    val iconSecondary: ColorResource,

    // default theming colors for buttons
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

    val iconConnectivityOnline: ColorResource,
    val iconConnectivityOffline: ColorResource,
    val textConnectivityOnline: ColorResource,
    val textConnectivityOffline: ColorResource,
    val bgConnectivityOnline: ColorResource,
    val bgConnectivityOffline: ColorResource,

    // textos
    val textFieldHintColor: ColorResource,
    val textFieldCursorColor: ColorResource,
    val textFieldSelectedFocusColor: ColorResource,
    val textFieldUnselectedFocusColor: ColorResource,

    // buttons
    val loadingButtonActiveColor: ColorResource,
    val loadingButtonLoadingColor: ColorResource,
    val loadingButtonDisabledColor: ColorResource,

    val scrimColor: ColorResource,

    val selectedContentColor: ColorResource,
    val unselectedContentColor: ColorResource,

    val bgOverlayHeaderDefault: ColorResource,
    val bgOverlayHeaderScroll: ColorResource,
    val textStartColor: ColorResource,
    val textEndColor: ColorResource,
    val btnBgWhiteAlpha: ColorResource,
    val btnBgGrayAlpha: ColorResource,
    val defaultTextColor: ColorResource,
) {
    object Dark : Theme (

        primary = ColorResource(0xFFE95D0F), // laranja
        primaryVariant = ColorResource(0xFFE95D0F), // laranja
        secondary = ColorResource(0xFF707070), // black 60% alpha
        secondaryVariant = ColorResource(0xFF707070), // black 60% alpha
        background = ColorResource(0xFFEFEFEF), // black 5% alpha
        surface = ColorResource(0xFF707070), // white
        error = ColorResource(0xFFF09C6D), // laranja 60% alpha
        onPrimary = ColorResource(0xFFFFFFFF), // white
        onSecondary = ColorResource(0xFFFFFFFF), // white
        onBackground = ColorResource(0xFF131313), // black
        onSurface = ColorResource(0xFF131313), // black
        onError = ColorResource(0xFFFFFFFF), // white

        iconConnectivityOnline = ColorResource(0xFF00D80A),
        iconConnectivityOffline = ColorResource(0xFFFFFFFF),
        textConnectivityOnline = ColorResource(0xFF131313),
        textConnectivityOffline = ColorResource(0xFFFFFFFF),
        bgConnectivityOnline = ColorResource(0xFF76DA96),
        bgConnectivityOffline = ColorResource(0xFFDC4657),

        textFieldHintColor = ColorResource(0xFF707070),
        textFieldCursorColor = ColorResource(0xFF131313),
        textFieldSelectedFocusColor = ColorResource(0xFFEFEFEF),
        textFieldUnselectedFocusColor = ColorResource(0xFF707070),

        loadingButtonActiveColor = ColorResource(0xFFE95D0F),
        loadingButtonLoadingColor = ColorResource(0xFFF09C6D),
        loadingButtonDisabledColor = ColorResource(0xFFEFEFEF),

        contentPrimary =  ColorResource(0xFFFFFFFF), // white
        contentSecondary =  ColorResource(0xFF131313), // black
        backgroundPrimary = ColorResource(0xFF414141), // black 80% alpha
        backgroundSecondary = ColorResource(0xFF707070), // black 60% alpha
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF), // white 40% alpha
        strokeSecondary = ColorResource(0xFF131313), // black
        divider = ColorResource(0xFFFFFFFF), // white
        textPrimary = ColorResource(0xFFFFFFFF), // white
        textSecondary = ColorResource(0xFF131313), // black
        textTertiary = ColorResource(0xFF131313), // black
        iconPrimary = ColorResource(0xFF131313), // black
        iconSecondary = ColorResource(0x99131313), // back 60% alpha
        content1 = ColorResource(0xFFFFFFFF), // white
        background1 = ColorResource(0xFFE95D0F), // laranja
        title = ColorResource(0xFF131313), // black
        titleSecondary = ColorResource(0xFFFFFFFF), // white
        subtitle = ColorResource(0xFF131313), // black
        description = ColorResource(0xFFE95D0F), // laranja
        contentCloseButton = ColorResource(0xFFFFFFFF), // white
        backgroundCloseButton = ColorResource(0xFFE95D0F), // laranja
        disabledBackgroundCloseButton = ColorResource(0x99131313), // back 60% alpha
        scrimColor = ColorResource(0xFF707070),

        selectedContentColor = ColorResource(0xFFE95D0F), // laranja
        unselectedContentColor = ColorResource(0x99131313), // back 60% alpha

        bgOverlayHeaderDefault = ColorResource(0x00FFFFFF), // white 0% alpha
        bgOverlayHeaderScroll = ColorResource(0xFFC0D6DF), // grey light
        textStartColor = ColorResource(0xFFFFFFFF), // back 60% alpha
        textEndColor = ColorResource(0x99131313), // back 60% alpha
        btnBgWhiteAlpha = ColorResource(0xFFFFFFFF), // white
        btnBgGrayAlpha = ColorResource(0xFFEFEFEF), // black 5% alpha
        defaultTextColor = ColorResource(0x99131313), // back 60% alpha
    )

    object Light : Theme (

        primary = ColorResource(0xFFE95D0F), // laranja
        primaryVariant = ColorResource(0xFFE95D0F), // laranja
        secondary = ColorResource(0xFF707070), // black 60% alpha
        secondaryVariant = ColorResource(0xFF707070), // black 60% alpha
        background = ColorResource(0xFFEFEFEF), // black 5% alpha
        surface = ColorResource(0xFFFFFFFF), // white
        error = ColorResource(0xFFF09C6D), // laranja 60% alpha
        onPrimary = ColorResource(0xFFFFFFFF), // white
        onSecondary = ColorResource(0xFFFFFFFF), // white
        onBackground = ColorResource(0xFF131313), // black
        onSurface = ColorResource(0xFF131313), // black
        onError = ColorResource(0xFFFFFFFF), // white

        iconConnectivityOnline = ColorResource(0xFF00D80A),
        iconConnectivityOffline = ColorResource(0xFFFFFFFF),
        textConnectivityOnline = ColorResource(0xFF131313),
        textConnectivityOffline = ColorResource(0xFFFFFFFF),
        bgConnectivityOnline = ColorResource(0xFF76DA96),
        bgConnectivityOffline = ColorResource(0xFFDC4657),

        textFieldHintColor = ColorResource(0xFF707070),
        textFieldCursorColor = ColorResource(0xFF131313),
        textFieldSelectedFocusColor = ColorResource(0xFFEFEFEF),
        textFieldUnselectedFocusColor = ColorResource(0xFF707070),

        loadingButtonActiveColor = ColorResource(0xFFE95D0F),
        loadingButtonLoadingColor = ColorResource(0xFFF09C6D),
        loadingButtonDisabledColor = ColorResource(0xFFEFEFEF),

        contentPrimary =  ColorResource(0xFFFFFFFF), // white
        contentSecondary =  ColorResource(0xFFE95D0F), // laranja
        backgroundPrimary = ColorResource(0xFF1894E1), // azul
        backgroundSecondary = ColorResource(0xFFFFFFFF), // white
        strokeSecondary = ColorResource(0xFFE95D0F), // laranja
        backgroundSecondaryAlpha = ColorResource(0x66FFFFFF), // white 40% alpha
        divider = ColorResource(0xFFEFEFEF), // black 5% alpha
        textPrimary = ColorResource(0xFF131313), // black
        textTertiary = ColorResource(0xFF707070), // black 60% alpha
        textSecondary = ColorResource(0xFFE95D0F), // laranja
        iconPrimary = ColorResource(0xFFE95D0F), // laranja
        iconSecondary = ColorResource(0xFFF09C6D), // laranja 60% alpha
        content1 = ColorResource(0xFFE95D0F), // laranja
        background1 = ColorResource(0xFFFFFFFF), // white
        title = ColorResource(0xFFFFFFFF), // white
        titleSecondary = ColorResource(0xFF131313), // black
        subtitle = ColorResource(0xFFFFFFFF), // white
        description = ColorResource(0xFF131313), // black
        contentCloseButton = ColorResource(0xFF414141), // black 80% alpha
        backgroundCloseButton = ColorResource(0xFFEFEFEF), // black 5% alpha
        disabledBackgroundCloseButton = ColorResource(0x99131313), // back 60% alpha
        scrimColor = ColorResource(0xFF707070),

        selectedContentColor = ColorResource(0xFFE95D0F), // laranja
        unselectedContentColor = ColorResource(0x99131313), // back 60% alpha

        bgOverlayHeaderDefault = ColorResource(0x00FFFFFF), // white 0% alpha
        bgOverlayHeaderScroll = ColorResource(0xFFC0D6DF), // grey light
        textStartColor = ColorResource(0xFFFFFFFF), // back 60% alpha
        textEndColor = ColorResource(0x99131313), // back 60% alpha
        btnBgWhiteAlpha = ColorResource(0xFFFFFFFF), // white
        btnBgGrayAlpha = ColorResource(0xFFEFEFEF), // black 5% alpha
        defaultTextColor = ColorResource(0x99131313), // back 60% alpha

    )
}
*/
