package com.cheerself.cheerself.utils.navigation

import com.cheerself.cheerself.utils.Constants
import kotlinx.coroutines.flow.MutableStateFlow

sealed class MainDestination(val route: String) {
    object WelcomeScreen: MainDestination(Constants.WELCOME_ROUTE)
    object SurveyScreen: MainDestination(Constants.SURVEY_ROUTE)
    object HomeScreen: MainDestination(Constants.HOME_ROUTE)
}