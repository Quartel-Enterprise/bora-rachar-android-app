package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.chip.price.model.PriceChipsModel
import com.quare.blitzsplit.utils.CurrencyFormatter
import javax.inject.Inject

class GetPriceChipsUseCase @Inject constructor(
    private val currencyFormatter: CurrencyFormatter,
) {

    operator fun invoke(): PriceChipsModel = PriceChipsModel(
        toPay = currencyFormatter.format(19.8),
        toReceive = currencyFormatter.format(250.0),
    )
}
