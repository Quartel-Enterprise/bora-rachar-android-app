package com.quare.blitzsplit.login.presentation.signin

import android.content.Intent
import android.content.IntentSender
import com.quare.blitzsplit.login.domain.model.SignInResult
import com.quare.blitzsplit.login.domain.model.UserData
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class GoogleAuthUiClient @Inject constructor(
    private val oneTapClient: SignInClient,
    private val auth: FirebaseAuth
) {

    suspend fun signIn(): IntentSender? {
        val result = runCatching {
            oneTapClient.beginSignIn(buildSignInRequest()).await()
        }.getOrNull()
        return result?.pendingIntent?.intentSender
    }

    suspend fun signInWithIntent(intent: Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val authResult = auth.signInWithCredential(googleCredentials).await()
            SignInResult.Success(
                userData = UserData(
                    id = authResult.user?.uid,
                    profilePictureUrl = authResult.user?.photoUrl?.toString()
                )
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            if (exception is CancellationException) throw exception
            SignInResult.Error(exception.message)
        }
    }

    private fun buildSignInRequest(): BeginSignInRequest = BeginSignInRequest.Builder()
        .setGoogleIdTokenRequestOptions(
            GoogleIdTokenRequestOptions.builder()
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
