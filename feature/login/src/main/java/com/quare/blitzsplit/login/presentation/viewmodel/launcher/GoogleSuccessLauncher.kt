package com.quare.blitzsplit.login.presentation.viewmodel.launcher

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import com.quare.blitzsplit.login.domain.model.SignInResult
import com.quare.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

internal class GoogleSuccessLauncher(
    private val scope: CoroutineScope,
    private val googleAuthUiClient: GoogleAuthUiClient,
    private val onSuccess: suspend (SignInResult) -> Unit
): OnSuccessResultLauncher {

    override fun onResult(result: ActivityResult) {
        if (result.isOk()) {
            result.data?.let { intent ->
                scope.launch {
                    val signResult = googleAuthUiClient.signInWithIntent(intent)
                    onSuccess(signResult)
                }
            }
        }
    }

    private fun ActivityResult.isOk() : Boolean = resultCode == ComponentActivity.RESULT_OK
}
