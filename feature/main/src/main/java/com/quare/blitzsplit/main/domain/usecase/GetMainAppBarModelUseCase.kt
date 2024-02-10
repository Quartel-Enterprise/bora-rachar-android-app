package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzsplit.user.domain.usecase.GetUserModel
import javax.inject.Inject

class GetMainAppBarModelUseCase @Inject constructor(
    private val getUserModel: GetUserModel,
    private val getPriceChips: GetPriceChipsUseCase,
) {
    suspend operator fun invoke(): MainAppBarModel = MainAppBarModel(
        photoUrl = getUserModel()?.profilePictureUrl,
        priceChipsModel = getPriceChips()
    )
}
