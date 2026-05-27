package com.stela.pharmasimapp.presentation.viewmodel

import com.stela.pharmasimapp.domain.model.ReaderStatus

data class ScannerState(
    val readerStatus : ReaderStatus = ReaderStatus.DISCONNECTED,
    val selectedOption : String = "UNIT_ASSOCIATION",
    val lastRead : String = "Nenhuma leitura",
    val status: String = "Aguardando leitura",
    val isScanning: Boolean = false,
    val showBottomSheet: Boolean = false

)