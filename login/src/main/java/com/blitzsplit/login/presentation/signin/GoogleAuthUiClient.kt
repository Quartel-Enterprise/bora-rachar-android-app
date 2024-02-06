package com.blitzsplit.login.presentation.signin

import android.content.Intent
import android.content.IntentSender
import com.blitzsplit.login.domain.model.SignInResult
import com.blitzsplit.login.domain.model.UserData
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class GoogleAuthUiClient @Inject constructor(
    private val oneTapClient: SignInClient,
) {
    private val auth = Firebase.auth

    suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        } catch (exception: Exception) {
            exception.printStackTrace()
            if (exception is CancellationException) throw exception
            null
        }
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

    suspend fun signOut() {
        try {
            auth.signOut()
        } catch (exception: Exception) {
            exception.printStackTrace()
            if (exception is CancellationException) throw exception
        }
    }

    fun getSignedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            id = uid,
            profilePictureUrl = photoUrl?.toString()
        )
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
