package com.stela.pharmasimapp.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.stela.pharmasimapp.data.manager.ReaderManager
import com.stela.pharmasimapp.presentation.theme.ui.PharmaSimAppTheme
import com.stela.pharmasimapp.presentation.viewmodel.MainViewModel
import com.stela.pharmasimapp.presentation.viewmodel.MainViewModelFactory

private lateinit var mainViewModel: MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val readerManager = ReaderManager(this)

        val factory = MainViewModelFactory(readerManager)

        mainViewModel = ViewModelProvider(
            this,
            factory
        )[MainViewModel::class.java]

        setContent {
            PharmaSimAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ScannerScreen(
                        viewModel = mainViewModel
                    )
                }
            }
        }
    }
}






