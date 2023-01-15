package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MultipleChoiceButton(
    onClick: () -> Unit,
    choice: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isSelected: Boolean = true,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(0.dp)
) {
    val containerColor = if (isSelected) {
        MaterialTheme.colorScheme.onSurfaceVariant.copy(0.3f)
    } else {
        Color.Transparent
    }
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = elevation,
        enabled = isEnabled,
        shape = CircleShape,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.onSurface.copy(0.5f)
        ),
        contentPadding = PaddingValues(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            containerColor = containerColor
        ),
    ) {
        Text(text = choice)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMultipleChoiceButton() {
    Column() {
        Row(Modifier.fillMaxWidth()) {
            MultipleChoiceButton(
                onClick = { /*TODO*/ },
                choice = "something",
                modifier = Modifier.weight(1f)
            )
            MultipleChoiceButton(
                isSelected = false,
                onClick = { /*TODO*/ },
                choice = "something else",
                modifier = Modifier.weight(1f)
            )
        }
        MultipleChoiceButton(
            isSelected = false,
            onClick = { /*TODO*/ },
            choice = "something else",
            modifier = Modifier.height(40.dp)
        )
    }
}