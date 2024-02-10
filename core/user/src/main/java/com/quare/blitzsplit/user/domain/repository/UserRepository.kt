package com.quare.blitzsplit.user.domain.repository

import com.quare.blitzsplit.user.domain.model.UserModel

interface UserRepository {
    suspend fun getUser(): UserModel?
    suspend fun deleteUserLocally()
}
