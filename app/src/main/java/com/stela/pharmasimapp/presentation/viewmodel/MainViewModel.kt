package com.stela.pharmasimapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stela.pharmasimapp.data.manager.ReaderManager
import com.stela.pharmasimapp.domain.model.Metadata
import com.stela.pharmasimapp.domain.model.ProcessingStatus
import com.stela.pharmasimapp.domain.model.RfidReadEvent
import com.stela.pharmasimapp.domain.model.Tag
import com.stela.pharmasimapp.domain.repository.ScannerRepository
import com.stela.pharmasimapp.domain.usecase.SendTagUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.UUID


class MainViewModel(private val readerManager: ReaderManager,
        private val sendTagUseCase: SendTagUseCase) : ViewModel() {

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
            logTag(tag)

            sendTagToApi(tag)
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

            ScannerEvent.onConnectReader -> {
                connect()
            }

            ScannerEvent.onStartScan -> {

                if (!_uiState.value.isConnected) {

                    _uiState.update {
                        it.copy(
                            message = "Conecte a leitora antes de iniciar o scan"
                        )
                    }

                    return
                }

                if (_uiState.value.isScanning) {

                    stopScan()

                    _uiState.update {
                        it.copy(
                            isScanning = false,
                            status = "Leitura parada"
                        )
                    }

                } else {

                    startScan()

                    _uiState.update {
                        it.copy(
                            isScanning = true,
                            status = "Lendo Tags"
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

            if (success) {

                _uiState.update {
                    it.copy(isConnected = true,
                        status = "Connected",
                        message = "Leitora Conectada")
                }
           } else {

               _uiState.update {
                   it.copy(isConnected = false,
                       status = "Disconnected",
                       message = "Conecte a leitora")
               }
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

    private fun sendTagToApi(tag: Tag) {

        val selectedType = _uiState.value.selectedOption

        if (selectedType == null) {

            _uiState.update {
                it.copy(
                    message = "Selecione uma operação"
                )
            }

            return
        }

        val event = RfidReadEvent(

            "A-01",

            tag.strepc,

            null,

            UUID.randomUUID().toString(),

            Metadata("android-app"),

            selectedType,

            ProcessingStatus.READY,

            getCurrentTimestamp(),

            "R-01",

            getCurrentTimestamp(),

            tag.intRssi
        )

        sendTagUseCase.execute(
            event,

            object : ScannerRepository.RepositoryCallback {

                override fun onSuccess() {

                    _uiState.update {
                        it.copy(
                            message = "Tag enviada com sucesso"
                        )
                    }
                }

                override fun onError(error: String) {

                    _uiState.update {
                        it.copy(
                            message = error
                        )
                    }
                }
            }
        )
    }

    private fun getCurrentTimestamp(): String {

        val sdf = SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            Locale.getDefault()
        )

        sdf.timeZone = TimeZone.getTimeZone("UTC")

        return sdf.format(Date())
    }


}