package com.stela.pharmasimapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
                        Text(text = "Select an option to scan")
                        Spacer(modifier = Modifier.padding(bottom = 16.dp))

//                      scanButtons(modifier = Modifier.padding(20.dp))
                        buttonsCard(modifier = Modifier.padding(10.dp))
                        Spacer(modifier = Modifier.padding(bottom = 16.dp))
                        scanStatusCard()
//                        scanStatus()

                    }

                }

            }
        }
    }

    @Composable
    fun scanButtons(modifier: Modifier = Modifier) {

        val buttonOptions = listOf("UNIT_ASSOCIATION", "BOX_ASSOCIATION", "BOX_CLOSURE")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(buttonOptions[0]) }

        Column(modifier.selectableGroup()) {
            buttonOptions.forEach { text ->
                Row(
                    modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = null
                    )
                    Text(
                        text = text
                        )
                }
            }
        }

    }

    @Composable
    fun scanStatus() {

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = ("Última leitura: "),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = ("Status: "),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal
            )
        }

    }

    @Composable
    fun scanStatusCard() {


        Card(colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
            modifier = Modifier.size(width = 200.dp, height = 80.dp)) {

            Column (
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Última leitura: ",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = "Status: ",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal
                )
            }
        }

    }

    @Composable
    fun buttonsCard(modifier : Modifier = Modifier) {

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
}






