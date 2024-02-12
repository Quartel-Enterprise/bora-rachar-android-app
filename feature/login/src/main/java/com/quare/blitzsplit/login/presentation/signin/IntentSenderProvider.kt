package com.quare.blitzsplit.login.presentation.signin

import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class IntentSenderProvider @Inject constructor(
    private val signInClient: SignInClient,
) {
    suspend fun signIn(): IntentSender? {
        val result = runCatching {
            signInClient.beginSignIn(buildSignInRequest()).await()
        }.getOrNull()
        return result?.pendingIntent?.intentSender
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
