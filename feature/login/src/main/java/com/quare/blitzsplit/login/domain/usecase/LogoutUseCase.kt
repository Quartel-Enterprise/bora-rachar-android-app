package com.quare.blitzsplit.login.domain.usecase

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val auth: FirebaseAuth
) {
    operator fun invoke() {
        auth.signOut()
    }
}
