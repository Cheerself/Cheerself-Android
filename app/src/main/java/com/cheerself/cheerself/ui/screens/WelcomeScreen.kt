package com.cheerself.cheerself.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.composables.PrimaryButton

@Composable
fun WelcomeScreen(
    navigateToSurveyScreen: () -> Unit
) {
    Column(
    ) {
        Greeting()
        ContinueButtons(onClick = navigateToSurveyScreen)
    }
}

@Composable
fun ContinueButtons(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(1f)
    ) {
        PrimaryButton(
            value = stringResource(id = R.string.asEmployee),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(1f),
            onClick = onClick
        )
        PrimaryButton(
            isFilled = false,
            value = stringResource(id = R.string.asIndividual),
            onClick = {}
        )
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(1f)
    ) {
        Spacer(modifier = Modifier.size(64.dp))
        AppLogo()
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = stringResource(id = R.string.welcome)
        )
        Text(
            text = stringResource(id = R.string.cheerselfQuote)
        )
    }
}

@Composable
fun AppLogo() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
//            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppLogo() {
    AppLogo()
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(navigateToSurveyScreen = {})
}