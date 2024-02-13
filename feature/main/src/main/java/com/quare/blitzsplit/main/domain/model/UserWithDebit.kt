package com.quare.blitzsplit.main.domain.model

import com.quare.blitzsplit.user.domain.model.UserModel

data class UserWithDebit(
    val model: UserModel,
    val debitType: DebitType,
    val debitAmount: String
)
