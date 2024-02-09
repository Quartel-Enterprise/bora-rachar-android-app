package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.mainappbar.domain.PriceChipsModel
import javax.inject.Inject

class GetPriceChipsUseCase @Inject constructor() {

    operator fun invoke(): PriceChipsModel = PriceChipsModel(
        toPay = "R$ 19,80",
        toReceive = "R$ 250,00",
    )
}
