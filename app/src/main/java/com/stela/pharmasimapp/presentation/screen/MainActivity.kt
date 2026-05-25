package com.stela.pharmasimapp.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
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
                    ScannerScreen()
                    }
                }
            }
        }
    }


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PartialBottomSheet() {
//
//    var showBottomSheet by remember { mutableStateOf(false) }
//    val sheetState = rememberModalBottomSheetState(
//        skipPartiallyExpanded = false,
//    )
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Button(onClick = { showBottomSheet = true }) {
//            Text(text = "Scan functionality")
//        }
//
//        if (showBottomSheet) {
//            ModalBottomSheet(
//                modifier = Modifier.fillMaxHeight(),
//                sheetState = sheetState,
//                onDismissRequest = { showBottomSheet = false }
//            ) {
//                Text(
//                    text = "A função de scan é utilizada na leitura de Tags RFID. Esta " +
//                            "função exige a utilização de uma leitora física apropriada."
//                )
//            }
//        }
//    }
//}







