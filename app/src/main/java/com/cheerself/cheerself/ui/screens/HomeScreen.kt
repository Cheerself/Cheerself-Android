package com.cheerself.cheerself.ui.screens

import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Scanner
import androidx.compose.material.icons.rounded.Scanner
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cheerself.cheerself.ui.composables.CheerselfTopAppBar
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.composables.DoctorTile

//Button(onClick = {
//    navController.navigate(MainDestination.WelcomeScreen.route)
//}) {
//    Text(text = "go back to welcome")
//
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
    ) {
        CheerselfTopAppBar(navIcon = {
            Icon(
                imageVector = Icons.Rounded.Scanner,
                contentDescription = "",
            )
        })
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.find_coach)
        )
        DoctorCategoryTabs()
        LazyColumn {
            item {
                val name = "Sahil Godara"
                val tagLine = "Specialises in stress management, and anxiety coaching."
                Column {
                    DoctorTile(name, tagLine)
                    DoctorTile(name, tagLine)
                }
                Column {
                    DoctorTile(name, tagLine)
                    DoctorTile(name, tagLine)
                }
                Column {
                    DoctorTile(name, tagLine)
                    DoctorTile(name, tagLine)
                }
                Column {
                    DoctorTile(name, tagLine)
                    DoctorTile(name, tagLine)
                }

            }
        }
    }
}

val DoctorCategory = listOf(
    "Stress", "Anxiety", "Productivity", "Low Confidence"
)

@Composable
fun DoctorCategoryTabs(

) {
    ScrollableTabRow(
        selectedTabIndex = 2,
        divider = {},
        edgePadding = 24.dp
    ) {
        DoctorCategory.forEach { category->
            DoctorCategoryChip(
                text = category,
                selected = true
            )
        }
    }
}

@Composable
fun DoctorCategoryChip(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
            else -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        },
        contentColor = when {
            selected -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.onSurface
        },
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}