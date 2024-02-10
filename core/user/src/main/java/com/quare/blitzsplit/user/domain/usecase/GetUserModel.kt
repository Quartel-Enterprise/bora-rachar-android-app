package com.quare.blitzsplit.user.domain.usecase

import com.quare.blitzsplit.user.domain.model.UserModel

interface GetUserModel {
    suspend operator fun invoke(): UserModel?
}
