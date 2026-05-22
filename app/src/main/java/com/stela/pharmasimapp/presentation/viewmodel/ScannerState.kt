package com.stela.pharmasimapp.presentation.viewmodel

data class ScannerState(
    val selectedOption : String = "UNIT_ASSOCIATION",
    val lastRead : String = "Nenhuma leitura",
    val status: String = "Aguardando leitura",
    val isScanning: Boolean = false,
    val showBottomSheet: Boolean = false

)