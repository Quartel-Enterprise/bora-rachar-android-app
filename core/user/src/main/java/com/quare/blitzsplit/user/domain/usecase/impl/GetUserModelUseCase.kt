package com.quare.blitzsplit.user.domain.usecase.impl

import com.quare.blitzsplit.user.domain.model.UserModel
import com.quare.blitzsplit.user.domain.repository.UserRepository
import com.quare.blitzsplit.user.domain.usecase.GetUserModel
import javax.inject.Inject

class GetUserModelUseCase @Inject constructor(
    private val userRepository: UserRepository,
) : GetUserModel {

    override suspend fun invoke(): UserModel? = userRepository.getUser()
}
