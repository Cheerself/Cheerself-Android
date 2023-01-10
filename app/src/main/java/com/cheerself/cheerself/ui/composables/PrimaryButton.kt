package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R

@Composable
fun PrimaryButton(
    value: String,
    modifier: Modifier = Modifier,
    isFilled: Boolean = true,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    when (isFilled) {
        true -> Button(
            onClick = onClick,
            enabled = isEnabled,
            modifier = modifier
                .height(50.dp),
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                disabledContentColor = Color.White
            )
        ) { Text(text = value) }
        false -> TextButton(
            enabled = isEnabled,
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.primary,
            )
        ) { Text(text = value) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButton() {
    PrimaryButton(
        onClick = {},
        isFilled = true,
        value = stringResource(id = R.string.asEmployee)
    )
}