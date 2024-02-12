package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzsplit.login.domain.model.SignInResult
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
    private val googleAuthUiClient: GoogleAuthUiClient,
) : ViewModel() {

    private val _state: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(isLoading = false)
    )

    val state: StateFlow<LoginState> = _state

    private val _action: MutableSharedFlow<LoginUiAction> = MutableSharedFlow()
    val action: SharedFlow<LoginUiAction> = _action

    fun onLogin() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            googleAuthUiClient.signIn()?.let { intentSender ->
                val intentSenderRequest = IntentSenderRequest.Builder(intentSender).build()
                emit(LoginUiAction.OpenGoogleLoginBottomSheet(intent = intentSenderRequest))
            }
        }
    }

    fun selectGoogleUser(result: ActivityResult) {
        if (result.isOk()) {
            result.data?.let { intent ->
                viewModelScope.launch {
                    val signResult = googleAuthUiClient.signInWithIntent(intent)
                    emitSignResult(signResult)
                }
            }
        }
    }

    private fun ActivityResult.isOk(): Boolean = resultCode == ComponentActivity.RESULT_OK

    private fun emitSignResult(result: SignInResult) {
        emit(
            when (result) {
                is SignInResult.Success -> LoginUiAction.NextScreen
                is SignInResult.Error -> LoginUiAction.ShowError(result.message ?: "Error")
            }
        )
    }

    private fun emit(action: LoginUiAction) {
        viewModelScope.launch {
            _action.emit(action)
        }
    }
}
