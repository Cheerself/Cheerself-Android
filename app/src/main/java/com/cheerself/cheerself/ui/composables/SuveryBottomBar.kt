package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SurveyBottomBar(
    shouldShowPreviousButton: Boolean,
//    shouldShowContinueButton: Boolean,
    isContinueButtonEnabled: Boolean,
    onContinuePressed: () -> Unit,
    onPreviousPressed: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            if (shouldShowPreviousButton) {
                PrimaryButton(
                    value = "Previous",
                    onClick = onPreviousPressed,
                    modifier = Modifier
                        .weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            PrimaryButton(
                value = "Continue",
                onClick = onContinuePressed,
                isEnabled = isContinueButtonEnabled,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview
@Composable
fun PreviewSurveyBottomBar() {
    MaterialTheme {
        SurveyBottomBar(
            shouldShowPreviousButton = false,
            isContinueButtonEnabled = true,
            onContinuePressed = { /*TODO*/ },
            onPreviousPressed = { }
        )
    }
}

