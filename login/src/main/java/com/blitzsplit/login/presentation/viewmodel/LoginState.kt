package com.blitzsplit.login.presentation.viewmodel

sealed interface LoginState {
    object Success : LoginState
    object NotLogged : LoginState
    data class Error(val message: String) : LoginState
}
