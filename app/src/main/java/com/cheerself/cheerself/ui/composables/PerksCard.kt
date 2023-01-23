package com.cheerself.cheerself.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.theme.OpenSauceOne

@Composable
fun PerksCard(
    perk: String,
    perkDescription: String,
    modifier: Modifier = Modifier,
    isComingSoon: Boolean = false
) {
    Card(
        modifier = modifier
            .padding(8.dp)
    ) {
        Box {
            Text(
                text = "Coming Soon",
                modifier = Modifier
                    .padding(top = 4.dp, start = 8.dp)
                    .alpha(
                        if (isComingSoon) 1f else 0f
                    )
            )
            Row(
                modifier = Modifier.height(100.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = perk,
                        style = TextStyle(
                            fontFamily = OpenSauceOne,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(text = perkDescription)
                }
                Image(
                    painter = painterResource(id = R.drawable.sampleimg),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(100.dp)
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPerksCard() {
    val perk = "Enjoy upto 50% off on Coaching"
    val perkDescription = "Starting at ₹799/session"
    PerksCard(
        perk = perk,
        perkDescription = perkDescription
    )
}
