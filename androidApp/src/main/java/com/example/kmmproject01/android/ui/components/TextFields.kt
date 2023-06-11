package com.example.kmmproject01.android.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmmproject01.android.DependencyInjectionForPreview
import com.example.kmmproject01.android.ui.theme.AndroidAppTheme
import com.example.kmmproject01.android.ui.theme.TextStyles
import com.example.kmmproject01.resources.Resources
import com.example.kmmproject01.resources.Spacing
import com.example.kmmproject01.resources.TextFieldErrorType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// 1) como criar estados compartilhados para validaçao de campos de texto
// 2) como definir os estilos dos campos de texto e font size compartilhado
// 3) como utilizar recursos de cores, dimensoes compartilhados
// 4) como criar um campo de texto customizado - reutilizavel

@Composable
fun DefaultTextInputField(
    initialInput: String = "",
    textFieldHint: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    errorState: StateFlow<Boolean> = MutableStateFlow(false),
    errorTypeState: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.None),
    onInputChanged: (input: String) -> Unit = {},
) {
    CustomTextField(
        initialInput = initialInput,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        trailingIcon = { Icon(imageVector = Icons.Default.Error, contentDescription = null) },
        textFieldHint = textFieldHint,
        errorState = errorState,
        errorTypeState = errorTypeState,
        onInputChanged = onInputChanged,
    )
}

@Composable
fun CustomTextField(
    initialInput: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    trailingIcon: @Composable (() -> Unit)? = null,
    textFieldHint: String = "",
    errorState: StateFlow<Boolean> = MutableStateFlow(false),
    errorTypeState: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.None),
    onInputChanged: (input: String) -> Unit = {},
) {

    val error by errorState.collectAsState()
    val errorType by errorTypeState.collectAsState()
    var input by remember { mutableStateOf(TextFieldValue(initialInput)) }

    return Column {

        OutlinedTextField(
            value = input,
            singleLine = true,
            isError = error,
            modifier = Modifier.height(Resources.Dimen.textInputField.minHeight),
            shape = RoundedCornerShape(Resources.Dimen.textInputField.roundCorner),
            trailingIcon = if (error) trailingIcon else null,
            keyboardOptions = keyboardOptions,
            onValueChange = {
                input = it
                onInputChanged(it.text)
            },

            textStyle = TextStyles.textField,

            placeholder = {
                Text(
                    text = textFieldHint,
                    color = Resources.Theme.textFieldHintColor.getColor(),
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Resources.Theme.backgroundSecondary.getColor(),
                cursorColor = Resources.Theme.textFieldCursorColor.getColor(),
                textColor = if(error) MaterialTheme.colors.error else LocalContentColor.current,
                focusedIndicatorColor = Resources.Theme.textFieldSelectedFocusColor.getColor(),
                unfocusedIndicatorColor = Resources.Theme.textFieldUnselectedFocusColor.getColor(),
            ),
        )

        Spacer.Tiny()

        when(errorType){
            TextFieldErrorType.NumberNotFound -> ErrorHintText(errorType)
            TextFieldErrorType.InvalidBirthdate -> ErrorHintText(errorType)
            TextFieldErrorType.InvalidCode -> ErrorHintText(errorType)
            else -> ErrorHintText(TextFieldErrorType.None)
        }
    }
}

@Composable
private fun ErrorHintText(errorType: TextFieldErrorType){
    Text(
        text = "texto localizado", //errorType.text.localized,
        style = TextStyles.textFieldHint,
        color = MaterialTheme.colors.error,
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun InputFieldsPreview(){
    DependencyInjectionForPreview()

    val errorStateTrue: StateFlow<Boolean> = MutableStateFlow(true)
    val errorStateFalse: StateFlow<Boolean> = MutableStateFlow(false)
    val errorNumberNotFound: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.NumberNotFound)
    val invalidDate: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.InvalidBirthdate)
    val invalidCode: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.InvalidCode)
    val errorNone: StateFlow<TextFieldErrorType> = MutableStateFlow(TextFieldErrorType.None)

    AndroidAppTheme {
        Column {
            DefaultTextInputField(
                initialInput = "076 888 44 22",
                keyboardType = KeyboardType.Phone,
                errorState = errorStateTrue,
                errorTypeState = errorNumberNotFound,
            )
            Spacer.Big()
            DefaultTextInputField(
                initialInput = "076 888 44 22",
                keyboardType = KeyboardType.Phone,
                errorState = errorStateFalse,
                errorTypeState = errorNone,
            )

            Spacer.Big()

            DefaultTextInputField(
                initialInput = "11/12-2023",
                keyboardType = KeyboardType.Text,
                errorState = errorStateTrue,
                errorTypeState = errorNone,
            )
        }
    }

}