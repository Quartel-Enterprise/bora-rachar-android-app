package com.quare.blitzsplit.login.presentation.signin

import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class IntentSenderProvider @Inject constructor(
    private val signInClient: SignInClient,
) {
    suspend fun signIn(): Result<IntentSender> = try {
        val result = signInClient.beginSignIn(buildSignInRequest()).await()
        result?.pendingIntent?.intentSender?.let { intentSender ->
            Result.success(intentSender)
        } ?: Result.failure(NullPointerException("IntentSender is null"))
    } catch (apiException: ApiException) {
        Result.failure(apiException)
    }

    private fun buildSignInRequest(): BeginSignInRequest = BeginSignInRequest.Builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(CLIENT_ID)
                .build()
        )
        .setAutoSelectEnabled(true)
        .build()

    companion object {
        private const val CLIENT_ID =
            "791706056713-ff3a65fa66j73mq4kj0ss97ht0pc4vrj.apps.googleusercontent.com"
    }
}
