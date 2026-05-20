package com.stela.pharmasimapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.stela.pharmasimapp.presentation.theme.ui.PharmaSimAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PharmaSimAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    )
                    {

                        Text(text = "SELECT AN OPTION TO SCAN")
                        Spacer(modifier = Modifier.padding(bottom = 16.dp))
                        ButtonsCard(modifier = Modifier.padding(10.dp))
                        Spacer(modifier = Modifier.padding(bottom = 16.dp))
                        ScanStatusCard()
                        Spacer(modifier = Modifier.padding(10.dp))
                        ScanButton {  }
                        Spacer(modifier = Modifier.padding(bottom = 10.dp))
                        PartialBottomSheet()

                    }

                }

            }
        }
    }

    @Composable
    fun ScanStatusCard() {

        Card(colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
            modifier = Modifier.size(width = 280.dp,
                height = 120.dp))
        {

            Column (modifier = Modifier.padding(20.dp),
            ) {
                Text(
                    text = "Last Read: Nenhuma leitura",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.padding(2.dp))

                Text(
                    text = "Status: Aguardando Leitura",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal
                )
            }
        }

    }

    @Composable
    fun ButtonsCard(modifier : Modifier = Modifier) {

        val btnOptions = listOf("UNIT_ASSOCIATION", "BOX_ASSOCIATION", "BOX_CLOSURE")

        var selectedOption by remember {
            mutableStateOf(btnOptions[0])
        }

        Card(colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
            modifier = Modifier.size(width = 280.dp, height = 240.dp))
        {

            Column(modifier = Modifier.padding(16.dp)) {

                btnOptions.forEach { option ->

                    Row(modifier = Modifier.fillMaxWidth()
                            .clickable{
                                selectedOption = option
                            }
                        .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(
                            selected = selectedOption == option,
                            onClick = {
                                selectedOption = option
                            }
                        )

                        Text(text = option,
                            modifier = Modifier.padding(8.dp))
                    }
                }

            }

        }

    }

    @Composable
    fun ScanButton(onClick: () -> Unit) {
        Button(
            onClick = {onClick()}
        ) {
            Text(text = "Start Scan")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet() {

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Column(modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = { showBottomSheet = true }) {
            Text(text = "Scan functionality")
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                onDismissRequest = {showBottomSheet = false}
            ) {
                Text(text = "A função de scan é utilizada na leitura de Tags RFID. Esta " +
                        "função exige a utilização de uma leitora física apropriada.")
            }
        }
    }


}





