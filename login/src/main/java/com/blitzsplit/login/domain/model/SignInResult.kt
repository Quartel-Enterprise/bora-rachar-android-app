package com.blitzsplit.login.domain.model

sealed interface SignInResult {
    data class Success(val userData: UserData) : SignInResult
    data class Error(val message: String?) : SignInResult
}
