package com.cheerself.cheerself.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cheerself.cheerself.utils.navigation.MainDestination

@Composable
fun HomeScreen(navController: NavHostController) {
    Button(onClick = {
        navController.navigate(MainDestination.WelcomeScreen.route)
    }) {
        Text(text = "go back to welcome")
    }
}