package com.cheerself.cheerself

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cheerself.cheerself.utils.Constants
import com.cheerself.cheerself.utils.navigation.MainDestination

@Composable
fun rememberCheerselfAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) = remember(navController, context) {
    CheerselfAppState(navController, context)
}

class CheerselfAppState(
    val navController: NavHostController,
    private val context: Context
) {
    fun navigateBack() {
        navController.popBackStack()
    }

    fun navigateToWelcomeScreen() {
        navController.navigate(MainDestination.WelcomeScreen.route)
    }

    fun navigateToSurveyScreen() {
        navController.navigate(MainDestination.SurveyScreen.route)
    }

    fun navigateToHomeScreen() {
        navController.navigate(MainDestination.HomeScreen.route)
    }
}