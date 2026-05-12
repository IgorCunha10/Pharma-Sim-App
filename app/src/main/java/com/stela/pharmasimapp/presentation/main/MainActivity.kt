package com.stela.pharmasimapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stela.pharmasimapp.presentation.theme.ui.PharmaSimAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PharmaSimAppTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    .padding(72.dp)) {

                 Column(
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.Center
                        )
                 {
                     Text(text = "Select an option to scan")
                     Spacer(modifier = Modifier.padding(bottom = 16.dp))

                     scanButtons()
                     Spacer(modifier = Modifier.padding(bottom = 16.dp))
                     scanStatus()
                 }

                }

            }
        }
    }

    @Composable
    fun scanButtons(modifier: Modifier = Modifier) {

        val buttonOptions = listOf("UNIT_ASSOCIATION", "BOX_ASSOCIATION", "BOX_CLOSURE")
        val (selectedOption, onOptionSelected) = remember{ mutableStateOf(buttonOptions[0]) }

      Column(modifier.selectableGroup()) {
            buttonOptions.forEach { text ->
                Row(
                    modifier.fillMaxWidth()
                        .height(20.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {onOptionSelected(text)},
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = null)
                    Text(
                        text = text,

                    )
                }
            }
        }

    }

    @Composable
    fun scanStatus() {

       Column(horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center) {
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
}


