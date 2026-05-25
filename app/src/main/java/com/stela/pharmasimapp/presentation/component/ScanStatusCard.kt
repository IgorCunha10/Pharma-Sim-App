package com.stela.pharmasimapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ScanStatusCard(lastRead : String,
                   status: String) {

    Card(
        colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.size(
            width = 280.dp,
            height = 120.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Last Read: $lastRead",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.padding(2.dp))

            Text(
                text = "Status: $status",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal
            )
        }
    }

}