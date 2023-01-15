package com.cheerself.cheerself.ui.screens.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.composables.CheerselfTextField
import com.cheerself.cheerself.ui.composables.QuestionTemplate

@Composable
fun Login() {
    var textState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }
//    var textFieldFocusState by remember { mutableStateOf(false) }
    Surface() {
        Column() {
            QuestionTemplate(
                title = stringResource(id = R.string.work_employee_email),
                description = stringResource(id = R.string.work_description)
            )
            CheerselfTextField(
                value = textState,
                onValueChange = { textState = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "E-Mail")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )
            Text(
                text = "Check eligible insurance providers",
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    Login()
}