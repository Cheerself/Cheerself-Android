package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cheerself.cheerself.R

@Composable
fun SurveyBottomBar(
    shouldShowPreviousButton: Boolean,
    shouldShowDoneButton: Boolean,
    isContinueButtonEnabled: Boolean,
    onContinuePressed: () -> Unit,
    onDonePressed: () -> Unit,
    onPreviousPressed: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "",
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = stringResource(id = R.string.data_sharing_note),
                fontSize = 10.sp,
                style = MaterialTheme.typography.bodySmall,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
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
                if (shouldShowDoneButton) {
                    PrimaryButton(
                        value = stringResource(id = R.string.getStarted),
                        onClick = onDonePressed,
                        isEnabled = isContinueButtonEnabled,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    PrimaryButton(
                        value = stringResource(id = R.string.Continue),
                        onClick = onContinuePressed,
                        isEnabled = isContinueButtonEnabled,
                        modifier = Modifier.weight(1f)
                    )
                }

            }
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
            onDonePressed = {},
            shouldShowDoneButton = true
        )
    }
}

