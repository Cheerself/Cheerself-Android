@file:OptIn(ExperimentalTextApi::class)

package com.cheerself.cheerself.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.cheerself.cheerself.R

/**
 * For Using Google Downloadable fonts
 */
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)


/**
 * Hard coded font as its not available on google fonts
 */
val OpenSauceOne = FontFamily(
    listOf(
        Font(R.font.open_sauce_one_light, FontWeight.Light),
        Font(R.font.open_sauce_one_light_italic, FontWeight.Light),
        Font(R.font.open_sauce_one_regular),
        Font(R.font.open_sauce_one_medium, FontWeight.Medium),
        Font(R.font.open_sauce_one_medium_italic, FontWeight.Medium),
        Font(R.font.open_sauce_one_italic),
        Font(R.font.open_sauce_one_bold, FontWeight.Bold),
        Font(R.font.open_sauce_one_bold_italic, FontWeight.Bold),
        Font(R.font.open_sauce_one_black, FontWeight.Black),
        Font(R.font.open_sauce_one_black_italic, FontWeight.Black),
        Font(R.font.open_sauce_one_semi_bold, FontWeight.SemiBold),
        Font(R.font.open_sauce_one_semi_bold_italic, FontWeight.SemiBold),
        Font(R.font.open_sauce_one_extra_bold, FontWeight.ExtraBold),
        Font(R.font.open_sauce_one_extra_bold_italic, FontWeight.ExtraBold),
    )
)

/**
 * Typography Styles
 */
val Typography = Typography(
    /**
     * Body
     */
    bodySmall = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    /**
     * Display
     */
    displaySmall = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displayLarge = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),

    /**
     * HeadLine
     */
    headlineSmall = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),

    /**
     * Label
     */
    labelSmall = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelLarge = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    /**
     * Title
     */
    titleSmall = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    titleMedium = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleLarge = TextStyle(
        fontFamily = OpenSauceOne,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)