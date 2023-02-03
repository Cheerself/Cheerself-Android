package com.cheerself.cheerself.ui.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong

@Composable
fun BackIcon(
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.size(35.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)),
        contentPadding = PaddingValues(0.dp),
    ) {
        Icon(
            imageVector = Icons.Rounded.ChevronLeft,
            contentDescription = "Back Icon",
            modifier = Modifier.size(50.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun SurveyTopAppBar(
    questionIndex: Int? = null,
    totalQuestionIndex: Int? = null,
    onBackPressed: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        BackIcon(onClick = onBackPressed)

        val animatedProgress by animateFloatAsState(
            targetValue = (questionIndex!! + 1) / totalQuestionIndex!!.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp)
                .fillMaxWidth()
                .clip(shape = CircleShape),
            trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
            color = MaterialTheme.colorScheme.primary
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheerselfTopAppBar(
    navIcon: @Composable () -> Unit
) {
    Column(modifier = Modifier) {
        TopAppBar(
            navigationIcon = navIcon,
            title = { Text("Good Morning") },
            windowInsets = WindowInsets(10.dp),
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "test")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenteredTopAppBar(
    title: String,
    onBackPressed: () -> Unit,
//    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = title)
            },
            navigationIcon = {
                BackIcon(onClick = onBackPressed)
            },
            modifier = modifier,
//            windowInsets = WindowInsets(10.dp),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                containerColor = MaterialTheme.colorScheme.primary,
//                scrolledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),

            ),
//            scrollBehavior = scrollBehavior
        )
}

@Preview(showBackground = true)
@Composable
fun PreviewCheerselfTopAppBar() {
    CheerselfTopAppBar({})
}

@Preview(showBackground = true)
@Composable
fun PreviewSurveyTopAppBar() {
    SurveyTopAppBar(
        questionIndex = 2,
        totalQuestionIndex = 10
    ) {}
}