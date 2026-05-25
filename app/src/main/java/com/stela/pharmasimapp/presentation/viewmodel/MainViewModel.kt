package com.stela.pharmasimapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stela.pharmasimapp.domain.usecase.StartScanUseCase
import com.stela.pharmasimapp.domain.usecase.StopScanUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        ScannerState()
    )

    val state = _uiState.asStateFlow()

    fun onEvent(event: ScannerEvent) {

        when(event) {
                is ScannerEvent.onOptionSelected -> {
                    _uiState.update {
                        it.copy(
                            selectedOption = event.option
                        )
                    }
                }

            ScannerEvent.onStartScan -> {
                _uiState.update {
                    it.copy(
                        isScanning = true,
                        status = "Scanning"
                    )
                }
//                startScan()
            }

            ScannerEvent.onStopScan -> {
                _uiState.update {
                    it.copy(
                        isScanning = false,
                        status = "Stopping read"
                    )
                }
//                stopScan()
            }

            ScannerEvent.onShowBottomSheet -> {
                _uiState.update {
                    it.copy(
                        showBottomSheet = true
                    )
                }
            }

            ScannerEvent.onHideBottomSheet -> {
                _uiState.update {
                    it.copy(
                        showBottomSheet = false
                    )
                }
            }



        }
    }

//    private fun startScan() {
//
//        viewModelScope.launch(Dispatchers.IO) {
//
//            startScanUseCase.execute()
//        }
//    }
//
//    private fun stopScan() {
//
//        viewModelScope.launch(Dispatchers.IO) {
//
//            stopScanUseCase.execute()
//        }
//    }


}