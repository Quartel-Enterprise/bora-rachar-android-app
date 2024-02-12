package com.quare.blitzsplit.main.presentation.viewmodel

import com.quare.blitzsplit.main.domain.model.MainAppBarModel
import com.quare.blitzplit.component.chip.price.PriceChipsClicks
import com.quare.blitzsplit.main.domain.model.MainDialogType

sealed interface MainAppBarState {
    data object Loading : MainAppBarState
    data class Success(
        val mainAppBarModel: MainAppBarModel,
        val priceChipsClicks: PriceChipsClicks,
        val currentDialog: MainDialogType?
    ) : MainAppBarState
}
