package com.cheerself.cheerself.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

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
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}