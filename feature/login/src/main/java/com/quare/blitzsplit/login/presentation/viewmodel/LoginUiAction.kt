package com.quare.blitzsplit.login.presentation.viewmodel

import androidx.activity.result.IntentSenderRequest

sealed interface LoginUiAction {
    data class OpenGoogleLoginBottomSheet(val intent: IntentSenderRequest): LoginUiAction
    object NextScreen: LoginUiAction
    data class ShowError(val message: String): LoginUiAction
}
