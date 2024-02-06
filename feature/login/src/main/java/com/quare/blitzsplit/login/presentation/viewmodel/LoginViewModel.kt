package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.activity.ComponentActivity
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzsplit.login.domain.model.SignInResult
import com.quare.blitzsplit.login.domain.usecase.LogoutUseCase
import com.quare.blitzsplit.login.presentation.signin.GoogleAuthUiClient
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
    private val logout: LogoutUseCase,
    private val googleAuthUiClient: GoogleAuthUiClient,
) : ViewModel() {

    private val _state: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(isLoading = false)
    )

    val state: StateFlow<LoginState> = _state

    private val _action: MutableSharedFlow<LoginUiAction> = MutableSharedFlow()
    val action: SharedFlow<LoginUiAction> = _action

    val onSuccessResultLauncher: OnSuccessResultLauncher = OnSuccessResultLauncher { result ->
        if (result.resultCode == ComponentActivity.RESULT_OK) {
            result.data?.let { intent ->
                viewModelScope.launch {
                    val signResult = googleAuthUiClient.signInWithIntent(intent)
                    updateState(signResult)
                }
            }
        }
    }

    fun onLogin() {
        setLoading(isLoading = true)
        viewModelScope.launch {
            googleAuthUiClient.signIn()?.let { intentSender ->
                val intentSenderRequest = IntentSenderRequest.Builder(intentSender).build()
                _action.emit(LoginUiAction.LaunchIntent(intent = intentSenderRequest))
            }
        }
    }

    fun onLogout() {
        logout()
        setLoading(isLoading = false)
    }

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    private fun updateState(result: SignInResult) {
        viewModelScope.launch {
            _action.emit(
                when (result) {
                    is SignInResult.Success -> LoginUiAction.NextScreen
                    is SignInResult.Error -> LoginUiAction.Error(result.message ?: "Error")
                }
            )
        }
    }
}
