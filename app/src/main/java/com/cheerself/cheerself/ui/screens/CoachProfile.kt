package com.cheerself.cheerself.ui.screens

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.ui.composables.BackIcon
import com.cheerself.cheerself.ui.composables.CenteredTopAppBar
import com.cheerself.cheerself.ui.composables.DoctorTile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoachProfile() {
//    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
//    val scrollBehavior = remember(decayAnimationSpec) {
//        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
//    }
//    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
//        state = rememberTopAppBarState(),
////        flingAnimationSpec = decayAnimationSpec,
//        canScroll = { true }
//    )
    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            CenteredTopAppBar(
                title = "My coach",
                onBackPressed = { /*TODO*/ },
//                scrollBehavior = scrollBehavior
            )

        }
    ) {
        Column(Modifier.padding(it)) {
            Spacer(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .blur(4.dp)
                    .background(color = MaterialTheme.colorScheme.primary.copy(0.5f))
            )
            val name = "Doctor name"
            val tagLine = "Specialises in stress management, and anxiety coaching."
            DoctorTile(name, tagLine)
        }
    }
}

