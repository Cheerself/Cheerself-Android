package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Row(modifier = modifier.fillMaxWidth()) {
        Box(modifier = Modifier.padding(PaddingValues(5.dp))) {
            Image(
                painter = painterResource(id = R.drawable.sampleimg),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        DoctorInfo(name = name, tagLine = tagLine)
    }
}

@Composable
fun DoctorInfo(name: String, tagLine: String) {
    Column() {
        Text(text = name)
        Text(text = tagLine)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDoctorTile() {
    val name = "Sahil Godara"
    val tagLine = "Specialises in stress management, and anxiety coaching."
    DoctorTile(name, tagLine)
}