package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R

@Composable
fun DoctorTile(
    name: String,
    tagLine: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .padding(PaddingValues(5.dp))
                .size(70.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sampleimg),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
            )
        }
        DoctorInfo(name = name, tagLine = tagLine)
    }
}

@Composable
fun DoctorInfo(name: String, tagLine: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = name)
        Spacer(modifier = Modifier.size(15.dp))
        Text(text = tagLine)
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDoctorTile() {
    val name = "Sahil Godara"
    val tagLine = "Specialises in stress management, and anxiety coaching."
    Column {
        DoctorTile(name, tagLine)
        DoctorTile(name, tagLine)
    }
}