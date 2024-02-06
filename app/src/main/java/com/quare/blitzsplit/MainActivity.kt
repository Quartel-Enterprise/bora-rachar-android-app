package com.quare.blitzsplit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quare.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import com.quare.blitzsplit.ui.theme.BlitzSplitTheme
import com.quare.blitzsplit.navigation.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var googleAuthUiClient: GoogleAuthUiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlitzSplitTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationComponent(
                        loginViewModel = viewModel(),
                        googleAuthUiClient = googleAuthUiClient
                    )
                }
            }
        }
    }
}
