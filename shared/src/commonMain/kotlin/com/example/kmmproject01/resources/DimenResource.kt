package com.example.kmmproject01.resources

import kotlin.native.concurrent.ThreadLocal

// 1) Definicao da regua das constantes
// 2) Implementacao Android e iOS
// 3) Incorporacao no recurso central de recursos compartilhados
// 4) Uso prático nas plataformas

@ThreadLocal
object LayoutDimens {
    private val dimensions by lazy { ComponentDimens.Dimens() }
    internal fun getDimens(): ComponentDimens = dimensions
}

abstract class ComponentDimens(
    val button: ButtonDimensResource,
    val surface: SurfaceDimensResource,
    val textInputField: TextFieldDimensResource,
    val defaultPadding: DefaultPaddingsResource,
    val header: HeaderDimensResource,
    val screen: ScreenDimensResource,
    val card: CardDimensResource,
    //...outros componentes adicione aqui
) {
    internal class Dimens : ComponentDimens(
        button = ButtonDimensResource(20, 0, 44, 34),
        surface = SurfaceDimensResource(20),
        textInputField = TextFieldDimensResource(40, 48),
        defaultPadding = DefaultPaddingsResource(16, 16, 16, 16),
        header = HeaderDimensResource(100, 45, 24, 0, 24, 12, 0.95f),
        screen = ScreenDimensResource(24, 0.1f, 100f, 20),
        card = CardDimensResource(15, 24)
    )
}

expect class HeaderDimensResource(
    defaultHeight: Int,
    defaultContentHeight: Int,
    defaultPaddingStart: Int,
    defaultPaddingTop: Int,
    defaultPaddingEnd: Int,
    defaultPaddingBottom: Int,
    defaultFakeBlurAlpha: Float,
)

expect class ScreenDimensResource(defaultPadding: Int, defaultStatusBarThreshold: Float, defaultBlendLimit: Float, defaultCurveInset: Int)
expect class CardDimensResource(defaultCornerRadius: Int, defaultPadding: Int)
expect class ButtonDimensResource(roundedCornerUnit: Int, minWidthUnit: Int, heightUnit: Int, smallHeightUnit: Int)

expect class SurfaceDimensResource(roundedCornerUnit: Int)
expect class TextFieldDimensResource(minWidthUnit: Int, minHeightUnit: Int, roundCornerUnit: Int = 0)

expect class DefaultPaddingsResource(
    defaultStart: Int,
    defaultEnd: Int,
    defaultTop: Int,
    defaultBottom: Int,
)