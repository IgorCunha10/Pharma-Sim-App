package com.stela.pharmasimapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stela.pharmasimapp.data.manager.ReaderManager
import com.stela.pharmasimapp.domain.usecase.SendTagUseCase
import kotlin.jvm.java

class MainViewModelFactory(
    private val readerManager: ReaderManager,
    private val sendTagUseCase : SendTagUseCase

) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                readerManager,
                sendTagUseCase
            ) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class: ${modelClass.name}"
        )
    }
}