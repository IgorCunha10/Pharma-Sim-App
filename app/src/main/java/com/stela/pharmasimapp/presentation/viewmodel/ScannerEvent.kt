package com.stela.pharmasimapp.presentation.viewmodel

import com.stela.pharmasimapp.domain.model.ScanType

sealed class ScannerEvent {

    data class onOptionSelected(val option: ScanType) : ScannerEvent()

    data object onStartScan : ScannerEvent()
    data object onConnectReader : ScannerEvent()
    data object onStopScan : ScannerEvent()

    data object onShowBottomSheet : ScannerEvent()
    data object onHideBottomSheet : ScannerEvent()

}