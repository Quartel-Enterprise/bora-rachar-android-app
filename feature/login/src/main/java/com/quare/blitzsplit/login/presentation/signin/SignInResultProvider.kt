package com.quare.blitzsplit.login.presentation.signin

import android.content.Intent
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.quare.blitzsplit.login.domain.model.SignInResult
import com.quare.blitzsplit.user.domain.model.UserModel
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class SignInResultProvider @Inject constructor(
    private val signInClient: SignInClient,
    private val auth: FirebaseAuth
) {
    suspend fun signInWithIntent(intent: Intent): SignInResult {
        val credential = signInClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val authResult = auth.signInWithCredential(googleCredentials).await()
            SignInResult.Success(
                userModel = UserModel(
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
}
