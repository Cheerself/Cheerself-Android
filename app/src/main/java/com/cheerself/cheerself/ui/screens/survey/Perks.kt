package com.cheerself.cheerself.ui.screens.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cheerself.cheerself.R
import com.cheerself.cheerself.ui.composables.PerksCard
import com.cheerself.cheerself.ui.composables.QuestionTemplate

@Composable
fun Perks(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val perk = "Enjoy upto 50% off on Coaching"
        val perkDescription = "Starting at ₹799/session"
        QuestionTemplate(
            title = stringResource(id = R.string.learn_abt_perks),
            description = stringResource(id = R.string.perks_description)
        )
        PerksCard(perk = perk, perkDescription = perkDescription)
        PerksCard(perk = perk, perkDescription = perkDescription)
        PerksCard(perk = perk, perkDescription = perkDescription)
    }
}