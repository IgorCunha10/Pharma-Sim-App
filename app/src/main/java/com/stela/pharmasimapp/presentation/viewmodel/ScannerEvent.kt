package com.stela.pharmasimapp.presentation.viewmodel

sealed class ScannerEvent {

    data class onOptionSelected(val option: String) : ScannerEvent()

    data object onStartScan : ScannerEvent()
    data object onConnectReader : ScannerEvent()
    data object onStopScan : ScannerEvent()

    data object onShowBottomSheet : ScannerEvent()
    data object onHideBottomSheet : ScannerEvent()

}