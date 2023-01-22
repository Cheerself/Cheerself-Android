package com.cheerself.cheerself.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cheerself.cheerself.CheerselfAppState
import com.cheerself.cheerself.rememberCheerselfAppState
import com.cheerself.cheerself.utils.navigation.MainDestination

@Composable
fun HomeScreen(navController: NavHostController) {
    Button(onClick = {
        navController.navigate(MainDestination.WelcomeScreen.route)
//        val navController = rememberNavController(navigators = )
    }) {
        Text(text = "go back to welcome")
    }
}