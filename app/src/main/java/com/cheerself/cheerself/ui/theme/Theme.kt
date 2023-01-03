package com.cheerself.cheerself.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)

private val LightColorScheme = lightColorScheme(
    primary = cheerself_light_primary,
    onPrimary = cheerself_light_onPrimary,
    primaryContainer = cheerself_light_primaryContainer,
    onPrimaryContainer = cheerself_light_onPrimaryContainer,
    secondary = cheerself_light_secondary,
    onSecondary = cheerself_light_onSecondary,
    secondaryContainer = cheerself_light_secondaryContainer,
    onSecondaryContainer = cheerself_light_onSecondaryContainer,
    tertiary = cheerself_light_tertiary,
    onTertiary = cheerself_light_onTertiary,
    tertiaryContainer = cheerself_light_tertiaryContainer,
    onTertiaryContainer = cheerself_light_onTertiaryContainer,
    error = cheerself_light_error,
    errorContainer = cheerself_light_errorContainer,
    onError = cheerself_light_onError,
    onErrorContainer = cheerself_light_onErrorContainer,
    background = cheerself_light_background,
    onBackground = cheerself_light_onBackground,
    surface = cheerself_light_surface,
    onSurface = cheerself_light_onSurface,
    surfaceVariant = cheerself_light_surfaceVariant,
    onSurfaceVariant = cheerself_light_onSurfaceVariant,
    outline = cheerself_light_outline,
    inverseOnSurface = cheerself_light_inverseOnSurface,
    inverseSurface = cheerself_light_inverseSurface,
    inversePrimary = cheerself_light_inversePrimary,
    surfaceTint = cheerself_light_surfaceTint,
    outlineVariant = cheerself_light_outlineVariant,
    scrim = cheerself_light_scrim,
)

@Composable
fun CheerselfTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is turned off until needed
    // dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
//    val colorScheme = when {
////        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
////            val context = LocalContext.current
////            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
////        }
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = LightColorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}