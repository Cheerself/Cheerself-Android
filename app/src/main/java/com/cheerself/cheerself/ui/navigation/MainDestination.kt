package com.cheerself.cheerself.ui.navigation

import com.cheerself.cheerself.utils.Constants

sealed class MainDestination(val route: String) {
    object WelcomeScreen: MainDestination(Constants.WELCOME_ROUTE)
    object SurveyScreen: MainDestination(Constants.SURVEY_ROUTE)
    object HomeScreen: MainDestination(Constants.HOME_ROUTE)
}