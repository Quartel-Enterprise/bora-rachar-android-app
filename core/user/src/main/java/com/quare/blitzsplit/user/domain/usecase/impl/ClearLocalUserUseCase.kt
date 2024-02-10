package com.quare.blitzsplit.user.domain.usecase.impl

import com.quare.blitzsplit.user.domain.repository.UserRepository
import com.quare.blitzsplit.user.domain.usecase.ClearLocalUser
import javax.inject.Inject

class ClearLocalUserUseCase @Inject constructor(
    private val repository: UserRepository,
) : ClearLocalUser {

    override suspend fun invoke() {
        repository.deleteUserLocally()
    }
}
