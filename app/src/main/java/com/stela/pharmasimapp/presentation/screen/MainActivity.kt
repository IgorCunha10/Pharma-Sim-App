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
import com.stela.pharmasimapp.data.remote.api.ScannerApi
import com.stela.pharmasimapp.data.repository.ScannerRepositoryImpl
import com.stela.pharmasimapp.domain.usecase.SendTagUseCase
import com.stela.pharmasimapp.presentation.theme.ui.PharmaSimAppTheme
import com.stela.pharmasimapp.presentation.viewmodel.MainViewModel
import com.stela.pharmasimapp.presentation.viewmodel.MainViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

private lateinit var mainViewModel: MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val readerManager = ReaderManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.15:8091/api/readings")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ScannerApi::class.java)

        val repository = ScannerRepositoryImpl(api)

        val sendTagUseCase = SendTagUseCase(repository)

        val factory = MainViewModelFactory(
            readerManager,
            sendTagUseCase
        )

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






