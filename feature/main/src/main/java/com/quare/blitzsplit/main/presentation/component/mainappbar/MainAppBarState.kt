package com.quare.blitzsplit.main.presentation.component.mainappbar

import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.pricechip.PriceChipsClicks

sealed interface MainAppBarState {
    data object Loading : MainAppBarState
    data class Success(
        val mainAppBarModel: MainAppBarModel,
        val priceChipsClicks: PriceChipsClicks
    ) : MainAppBarState
}
