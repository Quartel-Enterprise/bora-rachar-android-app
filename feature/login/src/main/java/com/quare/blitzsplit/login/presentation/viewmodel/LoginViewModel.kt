package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.quare.blitzsplit.login.domain.model.SignInResult
import com.quare.blitzsplit.login.presentation.signin.SignInResultProvider
import com.quare.blitzsplit.login.presentation.signin.IntentSenderProvider
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
    private val intentSenderProvider: IntentSenderProvider,
    private val signInResultProvider: SignInResultProvider,
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
            val result = intentSenderProvider.signIn()
            result.onSuccess { intentSender ->
                val intentSenderRequest = IntentSenderRequest.Builder(intentSender).build()
                emit(LoginUiAction.OpenGoogleLoginBottomSheet(intent = intentSenderRequest))
            }.onFailure { exception ->
                showLoginButtonWithoutLoading()
                val message = getLoginErrorMessage(exception)
                emit(LoginUiAction.ShowError(message))
            }
        }
    }

    private fun getLoginErrorMessage(exception: Throwable): String =
        if (exception is ApiException && exception.statusCode == CommonStatusCodes.CANCELED) {
            "You've tried to login too many times. Please wait 24 hours before trying again."
        } else {
            "Error while trying to login with Google"
        }

    fun selectGoogleUser(result: ActivityResult) {
        if (result.isOk()) {
            result.data?.let { intent ->
                viewModelScope.launch {
                    val signResult = signInResultProvider.signInWithIntent(intent)
                    emitSignResult(signResult)
                }
            }
        } else {
            showLoginButtonWithoutLoading()
        }
    }

    private fun showLoginButtonWithoutLoading() {
        _state.update { it.copy(isLoading = false) }
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
