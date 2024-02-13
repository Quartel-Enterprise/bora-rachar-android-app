package com.quare.blitzsplit.main.data

import com.quare.blitzplit.component.utils.StaticImages
import com.quare.blitzsplit.main.domain.model.DebitType
import com.quare.blitzsplit.main.domain.model.UserWithDebit
import com.quare.blitzsplit.user.domain.model.UserModel

object StaticUsersWithDebit {
    val data: List<UserWithDebit> = mutableListOf(
        UserWithDebit(
            model = UserModel(
                id = "1",
                profilePictureUrl = StaticImages.ARRIGHI,
                name = "Gabriel A."
            ),
            debitType = DebitType.PAY,
            debitAmount = "R$ 15,00"
        ),
        UserWithDebit(
            model = UserModel(
                id = "2",
                profilePictureUrl = StaticImages.THIAGO,
                name = "Thiago D."
            ),
            debitType = DebitType.PAY,
            debitAmount = "R$ 1,00"
        ),
        UserWithDebit(
            model = UserModel(
                id = "3",
                profilePictureUrl = StaticImages.FABIRCIO,
                name = "Fabrício\nK."
            ),
            debitType = DebitType.PAY,
            debitAmount = "R$ 249,99"
        ),
    ).apply {
        addAll(
            map {
                it.copy(
                    debitType = DebitType.RECEIVE,
                )
            }
        )
    }
}
