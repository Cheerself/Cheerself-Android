package com.cheerself.cheerself.ui.screens.survey

//import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cheerself.cheerself.ui.composables.SurveyBottomBar
import com.cheerself.cheerself.ui.composables.SurveyTopAppBar
import com.cheerself.cheerself.viewmodels.SurveyQuestionsData
import com.cheerself.cheerself.viewmodels.SurveyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.theme.CheerselfTheme
import com.cheerself.cheerself.utils.Constants.CONTENT_ANIMATION_DURATION
import com.cheerself.cheerself.viewmodels.SurveyQuestions

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SurveyScreen() {
    val viewModel = viewModel<SurveyViewModel>()
    val surveyScreenData = viewModel.surveyScreenData
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

    SurveyScreenScaffold(
        surveyScreenData = surveyScreenData,
        isContinueEnabled = viewModel.isContinueEnabled,
        isLastQuestion = viewModel.surveyScreenData.isLastQuestion,
        onContinuePressed = { viewModel.onContinuePressed() },
        onBackPressed = { viewModel.onBackPressed() }
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)

        AnimatedContent(
            targetState = surveyScreenData,
            transitionSpec = {
                val animationSpec: TweenSpec<IntOffset> =
                    tween(CONTENT_ANIMATION_DURATION)
                val direction = getTransitionDirection(
                    initialIndex = initialState.currentIndex,
                    targetIndex = targetState.currentIndex,
                )
                slideIntoContainer(
                    towards = direction,
                    animationSpec = animationSpec
                ) with slideOutOfContainer(
                    towards = direction,
                    animationSpec = animationSpec
                )
            }
        ) { targetState ->
            when (targetState.surveyQuestions) {
                SurveyQuestions.LOGIN -> {
                    Login(modifier = modifier)
                }
                SurveyQuestions.WHAT_BRINGS_YOU_HERE -> {
                    WhatBringsYouHere(
                        selectedAnswers = viewModel.bringsYouHereResponse,
                        possibleAnswers = possibleAnswers,
                        onOptionsSelected = viewModel::onBringsYouHereResponse,
                        modifier = modifier
                    )
                }
                SurveyQuestions.PERKS -> Perks()
            }
        }

    }

}

@OptIn(ExperimentalAnimationApi::class)
private fun getTransitionDirection(
    initialIndex: Int,
    targetIndex: Int
): AnimatedContentScope.SlideDirection {
    return if (targetIndex > initialIndex) {
        // Going forwards in the survey: Set the initial offset to start
        // at the size of the content so it slides in from right to left, and
        // slides out from the left of the screen to -fullWidth
        AnimatedContentScope.SlideDirection.Left
    } else {
        // Going back to the previous question in the set, we do the same
        // transition as above, but with different offsets - the inverse of
        // above, negative fullWidth to enter, and fullWidth to exit.
        AnimatedContentScope.SlideDirection.Right
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurveyScreenScaffold(
    surveyScreenData: SurveyQuestionsData,
    isContinueEnabled: Boolean,
    isLastQuestion: Boolean,
    onContinuePressed: () -> Unit,
    onBackPressed: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Surface() {
        Scaffold(
            topBar = {
                SurveyTopAppBar(
                    questionIndex = surveyScreenData.currentIndex,
                    totalQuestionIndex = surveyScreenData.totalQuestions,
                    onBackPressed = onBackPressed,
                )
            },
            content = content,
            bottomBar = {
                SurveyBottomBar(
                    shouldShowPreviousButton = surveyScreenData.shouldShowPreviousButton,
                    isContinueButtonEnabled = true,
                    onContinuePressed = onContinuePressed,
                    onPreviousPressed = onBackPressed,
                    isLastQuestion = isLastQuestion

                )
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    CheerselfTheme() {
        SurveyScreen()
    }
}

