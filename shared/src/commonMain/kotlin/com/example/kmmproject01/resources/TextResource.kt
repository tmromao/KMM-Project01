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

abstract class TextFieldErrorType(val text: TextResource){

    object None: TextFieldErrorType( text = TextResource(""))

    object NumberNotFound: TextFieldErrorType( text = Resources.Strings.textfield_number_not_found)

    object InvalidBirthdate : TextFieldErrorType( text = Resources.Strings.textfield_invalid_birthdate)

    object InvalidCode: TextFieldErrorType( text = Resources.Strings.textfield_invalid_code)
}