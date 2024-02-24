package com.quare.blitzsplit.main.domain.usecase

import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzsplit.user.domain.usecase.ClearLocalUser
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val auth: FirebaseAuth,
    private val clearLocalUser: ClearLocalUser,
) {

   suspend operator fun invoke() {
        clearLocalUser()
        auth.signOut()
    }
}
