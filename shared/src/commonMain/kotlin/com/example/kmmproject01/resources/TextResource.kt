package com.example.kmmproject01.resources

class TextResource(val name: String) {

    private var _text: String = ""

    internal fun setText(text: String) {
        _text = text
    }
}

fun getTextResource(text:String): TextResource {
    val resource = TextResource("")
    resource.setText(text)
    return resource
}