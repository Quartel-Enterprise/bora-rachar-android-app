package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzsplit.login.domain.usecase.GetUserDataUseCase
import javax.inject.Inject

class GetMainAppBarModelUseCase @Inject constructor(
    private val getUserData: GetUserDataUseCase,
    private val getPriceChips: GetPriceChipsUseCase,
) {
    operator fun invoke(): MainAppBarModel = MainAppBarModel(
        photoUrl = getUserData()?.profilePictureUrl,
        priceChipsModel = getPriceChips()
    )
}
