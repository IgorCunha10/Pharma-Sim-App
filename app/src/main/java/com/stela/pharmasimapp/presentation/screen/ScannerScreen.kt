package com.stela.pharmasimapp.presentation.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.stela.pharmasimapp.presentation.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stela.pharmasimapp.presentation.component.ButtonsCard
import com.stela.pharmasimapp.presentation.component.PartialBottomSheet
import com.stela.pharmasimapp.presentation.component.ScanButton
import com.stela.pharmasimapp.presentation.component.ScanStatusCard
import com.stela.pharmasimapp.presentation.viewmodel.ScannerEvent


@Composable
fun ScannerScreen(viewModel: MainViewModel) {

    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(state.message) {
        state.message?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

        Text(
            text = "Select an option to scan"
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        ButtonsCard(
            selectedOption = state.selectedOption,
            onOptionSelected = {
                viewModel.onEvent(
                    ScannerEvent.onOptionSelected(it)
                )
            }
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        ScanStatusCard(
            lastRead = state.lastRead,
            status = state.status
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        ScanButton(
            isScanning = state.isScanning,

            onClick = {

                Log.d("RFID", "CLICK BOTAO")

                // se conectado na leitor
                    // eu já estou lendo
                        //se sim - tem que para de ler
                // se eu não estou lendo
                // se não tentar conecta na leitora

                viewModel.onEvent(
                    ScannerEvent.onStartScan
                )

            }
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        PartialBottomSheet()

    }

}