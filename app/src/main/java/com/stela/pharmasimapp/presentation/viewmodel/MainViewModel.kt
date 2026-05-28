package com.stela.pharmasimapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stela.pharmasimapp.domain.model.Tag
import com.stela.pharmasimapp.domain.readermanager.ReaderManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(private val readerManager: ReaderManager) : ViewModel() {

    private val connectedLiveData = MutableLiveData<Boolean?>(false)
    private val errorLiveData = MutableLiveData<String?>()

    private val _uiState = MutableStateFlow(
        ScannerState()
    )

    val state = _uiState.asStateFlow()


    init {
        readerManager.setOnTagRead({ epcBean ->

            Log.d("RFID", "TAG DETECTADA")

            val tag = Tag(epcBean)

            Log.d("RFID", tag.strepc)
            logTag(tag)
        })

    }

    private fun logTag(tag: Tag) {
        // log da tag
        Log.d("MainViewmodel", "logTag: " + tag.strepc)

        _uiState.update {
            it.copy(
                lastRead = tag.strepc,
                tags = it.tags + tag
            )
        }

    }


    fun onEvent(event: ScannerEvent) {

        when (event) {
            is ScannerEvent.onOptionSelected -> {
                _uiState.update {
                    it.copy(
                        selectedOption = event.option
                    )
                }
            }

            ScannerEvent.onStartScan -> {

                if (_uiState.value.isConnected){

                    startScan()
                    _uiState.update {
                        it.copy(isScanning = true,
                                status = "Lendo Tags")

                    }
                } else {
                    _uiState.update {
                        it.copy(
                            message = "Conecte a leitora antes de iniciar o scan"
                        )
                    }
                }
            }

            ScannerEvent.onStopScan -> {

                stopScan()

                _uiState.update {
                    it.copy(
                        isScanning = false,
                        status = "Leitura parada"
                    )
                }
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

    fun connect() {
        readerManager.connect{ success, message ->
           _uiState.update {
               it.copy(
                   isConnected = success,
                   message = message
               )
           }
        }
    }

    fun startScan() {
        try {

            Log.d("RFID", "INICIANDO SCAN")
            readerManager.startScan()

        } catch (e: Exception) {
            errorLiveData.postValue("Erro ao iniciar scan")
        }
    }

    fun stopScan() {
        try {
            readerManager.stopScan()
        } catch (e: Exception) {
            errorLiveData.postValue("Erro ao parar scan")
        }
    }


}