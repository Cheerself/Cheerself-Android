package com.cheerself.cheerself.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.cheerself.cheerself.CheerselfAppState
import com.cheerself.cheerself.rememberCheerselfAppState
import com.cheerself.cheerself.ui.screens.HomeScreen
import com.cheerself.cheerself.ui.screens.WelcomeScreen
import com.cheerself.cheerself.ui.screens.survey.SurveyScreen
import com.cheerself.cheerself.utils.Constants

@Composable
fun CheerselfApp(
    appState: CheerselfAppState = rememberCheerselfAppState(),
) {
    NavHost(
        navController = appState.navController,
        startDestination = MainDestination.WelcomeScreen.route
    ) {
        composable(MainDestination.WelcomeScreen.route) {
            WelcomeScreen(
                navigateToSurveyScreen = { appState.navigateToSurveyScreen() }
            )
        }
        composable(MainDestination.SurveyScreen.route) {
            SurveyScreen(navController = appState.navController)
        }
        composable(MainDestination.HomeScreen.route) {
            HomeScreen(navController = appState.navController)
        }
    }
}

