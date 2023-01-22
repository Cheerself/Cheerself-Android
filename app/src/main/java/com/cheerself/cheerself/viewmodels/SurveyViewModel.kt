package com.cheerself.cheerself.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {
    // ---- login process ----


    private var questionIndex = 0
    private val questionOrder: List<SurveyQuestions> = listOf(
        SurveyQuestions.LOGIN,
        SurveyQuestions.WHAT_BRINGS_YOU_HERE,
        SurveyQuestions.PERKS,
    )

    // ---- response exposed as state ----
    enum class Screen { Welcome, SignUp, SignIn, Survey }
    private val _isLoginComplete = mutableStateOf(false)
    val isLoginComplete: Boolean
        get() = _isLoginComplete.value

    private val _bringsYouHereResponse = mutableStateListOf<Int>()
    val bringsYouHereResponse: List<Int>
        get() = _bringsYouHereResponse


    fun onBringsYouHereResponse(selected: Boolean, answer: Int) {
        if (selected) {
            _bringsYouHereResponse.add(answer)
        } else {
            _bringsYouHereResponse.remove(answer)
        }
    }


    //  ----- survey status as state -----
    private val _isSurveyComplete = mutableStateOf(false)
    val isSurveyComplete: Boolean
        get() = _isSurveyComplete.value

    private val _isContinueEnabled = mutableStateOf(false)
    val isContinueEnabled: Boolean
        get() = _isContinueEnabled.value

    private val _surveyScreenData = mutableStateOf(createSurveyScreenData())
    val surveyScreenData: SurveyQuestionsData
        get() = _surveyScreenData.value

    /**
     * Returns true if the ViewModel handled the back press (i.e., it went back one question)
     */
    fun onBackPressed(): Boolean {
        if (questionIndex == 0) {
            return false
        }
        changeQuestion(questionIndex - 1)
        return true
    }
    fun onDonePressed() {
        _isSurveyComplete.value = true
    }
    fun onContinuePressed() {
        changeQuestion(questionIndex + 1)
    }
    fun onPreviousPressed() {
        if (questionIndex == 0) {
            throw IllegalStateException("onPreviousPressed when on question 0")
        }
        changeQuestion(questionIndex - 1)
    }
    private fun changeQuestion(newQuestionIndex: Int) {
        questionIndex = newQuestionIndex
//        _isNextEnabled.value = getIsNextEnabled()
        _surveyScreenData.value = createSurveyScreenData()
    }
//    private fun getIsNextEnabled() {
//        when (questionOrder[questionIndex]) {
//            SurveyQuestions.LOGIN -> _isLoginComplete.value = true
//            SurveyQuestions.WHAT_BRINGS_YOU_HERE -> _superheroResponse.value != null
//            SurveyQuestions.PERKS -> _takeawayResponse.value != null
//        }
//    }

    private fun createSurveyScreenData(): SurveyQuestionsData {
        return SurveyQuestionsData(
            currentIndex = questionIndex,
            totalQuestions = questionOrder.size,
            shouldShowPreviousButton = questionIndex > 0,
            shouldShowDoneButton = questionIndex == questionOrder.size - 1,
            isLastQuestion = questionIndex == questionOrder.lastIndex,
            surveyQuestions = questionOrder[questionIndex]
        )
    }
}

/**
 * Consider it a valid email if there is some text before and after "@"
 */
private val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"

data class SurveyQuestionsData(
    val currentIndex: Int,
    val totalQuestions: Int,
    val isLastQuestion: Boolean,
    val shouldShowPreviousButton: Boolean,
    val shouldShowDoneButton: Boolean,
    val surveyQuestions: SurveyQuestions
)

enum class SurveyQuestions {
    LOGIN,
    WHAT_BRINGS_YOU_HERE,
    PERKS
}