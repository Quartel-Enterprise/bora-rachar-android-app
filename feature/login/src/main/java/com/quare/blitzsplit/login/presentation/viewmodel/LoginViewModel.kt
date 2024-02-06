package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzsplit.login.domain.model.SignInResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.NotLogged)
    val state: StateFlow<LoginState> = _state

    fun onSignInResult(result: SignInResult) {
        viewModelScope.launch {
            _state.update {
                when (result) {
                    is SignInResult.Success -> LoginState.Success
                    is SignInResult.Error -> LoginState.Error(result.message ?: "Error")
                }
            }
        }
    }

    fun onLogout() {
        viewModelScope.launch {
            _state.update {
                LoginState.NotLogged
            }
        }
    }
}
