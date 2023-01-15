package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cheerself.cheerself.R

@Composable
fun QuestionTemplate(
    title: String,
    description: String,
) {
    Column() {
        Text(
            text = title
        )
        Text(
            text = description
        )
    }
}