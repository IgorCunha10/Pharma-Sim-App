package com.stela.pharmasimapp.presentation.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConnectButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Connect")
    }
}
