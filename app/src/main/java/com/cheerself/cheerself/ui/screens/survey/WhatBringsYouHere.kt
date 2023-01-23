package com.cheerself.cheerself.ui.screens.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.composables.MultipleChoiceButton
import com.cheerself.cheerself.ui.composables.QuestionTemplate

@Composable
fun WhatBringsYouHere(
    selectedAnswers: List<Int>,
    possibleAnswers: List<Int>,
    onOptionsSelected: (selected: Boolean, answer: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        QuestionTemplate(
            title = stringResource(id = R.string.what_brings_you_here),
            description = stringResource(id = R.string.select_2),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
//            contentPadding = PaddingValues(8.dp),
        ) {
            items(
                possibleAnswers,
                span = {
                    GridItemSpan(
                        if (it == possibleAnswers.last()) 2 else 1
                    )
                }
            ) { possibleAnswer ->
                val selected = selectedAnswers.contains(possibleAnswer)
                MultipleChoiceButton(
                    onClick = { onOptionsSelected(!selected, possibleAnswer) },
                    choice = stringResource(id = possibleAnswer),
                    isSelected = selected
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWhatBringsYouHere() {
    val possibleAnswers = listOf(
        R.string.stress,
        R.string.anxiety,
        R.string.burnouts,
        R.string.depression,
        R.string.loneliness,
        R.string.self_esteem,
        R.string.nutrition,
        R.string.sleeping,
        R.string.something_else
    )
    val selectedAnswers = remember { mutableStateListOf(R.string.something_else) }

    WhatBringsYouHere(
        possibleAnswers = possibleAnswers,
        selectedAnswers = selectedAnswers,
        onOptionsSelected = { _, _ -> }
    )
}