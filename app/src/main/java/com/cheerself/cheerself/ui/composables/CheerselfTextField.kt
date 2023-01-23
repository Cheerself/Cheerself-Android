package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.cheerself.cheerself.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheerselfTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    label: @Composable () -> Unit,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions,
    shape: Shape = CircleShape
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        readOnly = readOnly,
        enabled = enabled,
        isError = isError,
        label = label,
        singleLine = singleLine,
        shape = shape,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            unfocusedLabelColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
        ),
        placeholder = {
            Text(text = "example@cheerself.com")
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.mail_icon),
                contentDescription = ""
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCheerselfTextField() {
    var value by remember { mutableStateOf(TextFieldValue("")) }
    CheerselfTextField(
        value = value,
        onValueChange = { value = it },
        label = {
            Text(text = "E-Mail")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    )
}