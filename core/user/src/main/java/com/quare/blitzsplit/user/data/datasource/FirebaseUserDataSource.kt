package com.quare.blitzsplit.user.data.datasource

import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzsplit.user.domain.model.UserModel
import javax.inject.Inject

class FirebaseUserDataSource @Inject constructor(private val auth: FirebaseAuth) {

    fun getUser(): UserModel? = auth.currentUser?.run {
        UserModel(
            id = uid,
            profilePictureUrl = photoUrl?.toString(),
            name = displayName
        )
    }
}
