package com.quare.blitzsplit.login.domain.usecase

import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzsplit.login.domain.model.UserData
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(
    private val auth: FirebaseAuth,
) {
    operator fun invoke(): UserData? = auth.currentUser?.run {
        UserData(
            id = uid,
            profilePictureUrl = photoUrl?.toString()
        )
    }
}
