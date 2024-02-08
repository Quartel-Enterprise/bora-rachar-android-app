package com.quare.blitzsplit.login.presentation

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quare.blitzsplit.login.presentation.component.notlogged.LoginContent
import com.quare.blitzsplit.login.presentation.viewmodel.LoginUiAction
import com.quare.blitzsplit.login.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    onNextScreen: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val loginState by loginViewModel.state.collectAsStateWithLifecycle()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            loginViewModel.onSuccessResultLauncher.onResult(result)
        }
    )

    LaunchedEffect(key1 = Unit) {
        loginViewModel.action.collectLatest { action ->
            when (action) {
                is LoginUiAction.OpenGoogleLoginBottomSheet -> launcher.launch(action.intent)
                is LoginUiAction.NextScreen -> onNextScreen()
                is LoginUiAction.ShowError -> Toast.makeText(
                    context,
                    action.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        LoginContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            onLogin = loginViewModel::onLogin,
            isLoading = loginState.isLoading
        )
    }
}

