package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzsplit.login.domain.model.SignInResult
import com.quare.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import com.quare.blitzsplit.login.presentation.viewmodel.launcher.GoogleSuccessLauncher
import com.quare.blitzsplit.login.presentation.viewmodel.launcher.OnSuccessResultLauncher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val googleAuthUiClient: GoogleAuthUiClient,
) : ViewModel() {

    private val _state: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(isLoading = false)
    )

    val state: StateFlow<LoginState> = _state

    private val _action: MutableSharedFlow<LoginUiAction> = MutableSharedFlow()
    val action: SharedFlow<LoginUiAction> = _action

    val onSuccessResultLauncher: OnSuccessResultLauncher = GoogleSuccessLauncher(
        scope = viewModelScope,
        googleAuthUiClient = googleAuthUiClient,
        onSuccess = ::emitAction
    )

    fun onLogin() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            googleAuthUiClient.signIn()?.let { intentSender ->
                val intentSenderRequest = IntentSenderRequest.Builder(intentSender).build()
                _action.emit(LoginUiAction.OpenGoogleLoginBottomSheet(intent = intentSenderRequest))
            }
        }
    }

    private suspend fun emitAction(result: SignInResult) {
        _action.emit(
            when (result) {
                is SignInResult.Success -> LoginUiAction.NextScreen
                is SignInResult.Error -> LoginUiAction.ShowError(result.message ?: "Error")
            }
        )
    }
}
