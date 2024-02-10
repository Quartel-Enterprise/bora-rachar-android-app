package com.quare.blitzsplit.login.domain.model

import com.quare.blitzsplit.user.domain.model.UserModel

sealed interface SignInResult {
    data class Success(val userModel: UserModel) : SignInResult
    data class Error(val message: String?) : SignInResult
}
