package com.quare.blitzsplit.user.data.repository

import com.quare.blitzsplit.user.data.datasource.FirebaseUserDataSource
import com.quare.blitzsplit.user.data.datasource.local.LocalUserDataSource
import com.quare.blitzsplit.user.domain.model.UserModel
import com.quare.blitzsplit.user.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localUserDataSource: LocalUserDataSource,
    private val firebaseUserDataSource: FirebaseUserDataSource,
) : UserRepository {

    override suspend fun getUser(): UserModel? = localUserDataSource.getUser().takeIf { localUser ->
        !localUser?.id.isNullOrEmpty()
    } ?: firebaseUserDataSource.getUser()?.also {
        localUserDataSource.saveUser(it)
    }


    override suspend fun deleteUserLocally() {
        localUserDataSource.clear()
    }
}
