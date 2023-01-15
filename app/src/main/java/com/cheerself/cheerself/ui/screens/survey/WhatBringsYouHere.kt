package com.cheerself.cheerself.ui.screens.survey

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.composables.MultipleChoiceButton
import com.cheerself.cheerself.ui.composables.QuestionTemplate

@Composable
fun WhatBringsYouHere() {

    // TODO make something else btn take whole width
    val choices = listOf(
        stringResource(id = R.string.stress),
        stringResource(id = R.string.anxiety),
        stringResource(id = R.string.burnouts),
        stringResource(id = R.string.depression),
        stringResource(id = R.string.loneliness),
        stringResource(id = R.string.self_esteem),
        stringResource(id = R.string.nutrition),
        stringResource(id = R.string.sleeping),
        stringResource(id = R.string.something_else)
    )
    Column() {
        QuestionTemplate(
            title = stringResource(id = R.string.what_brings_you_here),
            description = stringResource(id = R.string.select_2)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
        ) {
            items(
                choices,
                span = {
                    GridItemSpan(
                        if (it == choices.last()) 2 else 1
                    )
                }
            ) { choice ->
                MultipleChoiceButton(
                    onClick = { /*TODO*/ },
                    choice = choice,
                )
            }
//            item(span = { GridItemSpan(maxCurrentLineSpan) }) {
//                MultipleChoiceButton(
//                    onClick = { /*TODO*/ },
//                    choice = stringResource(id = R.string.something_else)
//                )
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWhatBringsYouHere() {
    WhatBringsYouHere()
}