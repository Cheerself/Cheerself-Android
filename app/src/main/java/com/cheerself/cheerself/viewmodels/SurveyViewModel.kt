package com.cheerself.cheerself.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {

    private val questionOrder: List<SurveyQuestions> = listOf(
        SurveyQuestions.LOGIN,
        SurveyQuestions.WHAT_BRINGS_YOU_HERE,
        SurveyQuestions.PERKS,
    )

    //  ----- survey status as state -----
    private val _isSurveyComplete = mutableStateOf(false)
    val isSurveyComplete: Boolean
        get() = _isSurveyComplete.value

    private val _isContinueEnabled = mutableStateOf(false)
    val isContinueEnabled: Boolean
        get() = _isContinueEnabled.value
}

data class SurveyQuestionsData(
    val currentIndex: Int,
    val totalQuestions: Int,
    val shouldShowPreviousButton: Boolean,
    val surveyQuestions: SurveyQuestions
)

enum class SurveyQuestions {
    LOGIN,
    WHAT_BRINGS_YOU_HERE,
    PERKS
}