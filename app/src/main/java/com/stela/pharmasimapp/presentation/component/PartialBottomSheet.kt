package com.stela.pharmasimapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet() {

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()

    Column(modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {
            showBottomSheet = true
        })
        {
            Text("Scan Functionality")
        }

        if (showBottomSheet) {

            ModalBottomSheet(
                modifier = androidx.compose.ui.Modifier.fillMaxHeight(),
                sheetState = sheetState,

                onDismissRequest = {
                    showBottomSheet = false
                }
            ) {
                Text(
                    text = "A função de scan é utilizada na leitura de tags RFID"
                )
            }
        }
    }
}