package com.stela.pharmasimapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stela.pharmasimapp.domain.model.ScanType

@Composable
fun ButtonsCard(selectedOption : ScanType?,
                onOptionSelected: (ScanType) -> Unit) {

    val btnOptions = listOf(
        ScanType.UNIT_ASSOCIATION,
        ScanType.BOX_ASSOCIATION,
        ScanType.BOX_CLOSURE
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.size(
            width = 270.dp,
            height = 280.dp
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            btnOptions.forEach { option ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onOptionSelected(option)
                    }
                    .padding(8.dp),

                    verticalAlignment = Alignment.CenterVertically) {

                    RadioButton(
                        selected = selectedOption == option,

                        onClick = {
                            onOptionSelected(option)
                        }
                    )

                    Text(text = option.name,
                        modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}