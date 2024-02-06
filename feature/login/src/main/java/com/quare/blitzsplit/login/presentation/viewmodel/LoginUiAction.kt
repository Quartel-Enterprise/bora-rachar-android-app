package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.activity.result.IntentSenderRequest

sealed interface LoginUiAction {
    data class LaunchIntent(val intent: IntentSenderRequest): LoginUiAction
    object NextScreen: LoginUiAction
    data class Error(val message: String): LoginUiAction
}
