package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R

@Composable
fun SurveyBottomBar(
    shouldShowPreviousButton: Boolean,
//    shouldShowContinueButton: Boolean,
    isContinueButtonEnabled: Boolean,
    isLastQuestion: Boolean,
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
                    isFilled = false,
                    onClick = onPreviousPressed,
                    modifier = Modifier
                        .weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            PrimaryButton(
                value = if (isLastQuestion) stringResource(id = R.string.getStarted)
                    else stringResource(id = R.string.Continue) ,
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
            onContinuePressed = { },
            onPreviousPressed = { },
            isLastQuestion = true
        )
    }
}

