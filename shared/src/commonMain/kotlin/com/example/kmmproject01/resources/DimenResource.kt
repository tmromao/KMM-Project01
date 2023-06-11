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
    val textInputField: TextFieldDimensResource,
    //...outros componentes adicione aqui
){
    internal class Dimens:ComponentDimens(
        button = ButtonDimensResource(20, 0, 44, 34),
        textInputField = TextFieldDimensResource(40, 48),
    )
}

expect class ButtonDimensResource(roundedCornerUnit: Int, minWidthUnit:Int, heightUnit:Int, smallHeightUnit:Int)
expect class TextFieldDimensResource(minWidthUnit: Int, minHeightUnit: Int, roundCornerUnit: Int = 0)