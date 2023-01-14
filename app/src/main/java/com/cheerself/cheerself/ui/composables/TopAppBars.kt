package com.cheerself.cheerself.ui.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R

@Composable
fun SurveyTopAppBar(
    questionIndex: Int,
    totalQuestionIndex: Int,
    onBackPressed: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedButton(
            onClick = onBackPressed,
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, Color.Black),
            contentPadding = PaddingValues(0.dp),

            ) {
            Icon(
                imageVector = Icons.Rounded.ChevronLeft,
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }

        val animatedProgress by animateFloatAsState(
            targetValue = (questionIndex + 1) / totalQuestionIndex.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .padding(start = 50.dp,end = 50.dp)
                .clip(shape = CircleShape),
            trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheerselfTopAppBar(
    backIcon: @Composable () -> Unit
) {
//    Surface {
//        TopAppBar(
//            navigationIcon = backIcon
//
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSurveyTopAppBar() {
    SurveyTopAppBar(
        questionIndex = 2,
        totalQuestionIndex = 10,
        onBackPressed = {}
    )
}