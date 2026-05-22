package com.stela.pharmasimapp.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
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
//    Column(modifier = Modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally) {
//
//        Button(onClick = { showBottomSheet = true }) {
//            Text(text = "Scan functionality")
//        }
//
//        if (showBottomSheet) {
//            ModalBottomSheet(
//                modifier = Modifier.fillMaxHeight(),
//                sheetState = sheetState,
//                onDismissRequest = {showBottomSheet = false}
//            ) {
//                Text(text = "A função de scan é utilizada na leitura de Tags RFID. Esta " +
//                        "função exige a utilização de uma leitora física apropriada.")
//            }
//        }
//    }







