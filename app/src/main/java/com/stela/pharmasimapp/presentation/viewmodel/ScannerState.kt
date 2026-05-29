package com.stela.pharmasimapp.presentation.viewmodel

import com.stela.pharmasimapp.domain.model.Tag

data class ScannerState(
    val selectedOption : String = "",
    val lastRead : String = "",
    val status: String = "",
    val isScanning: Boolean = false,
    val showBottomSheet: Boolean = false,
    val isConnected: Boolean = false,
    val message: String? = null,

    val tags: List<Tag> = emptyList()

)