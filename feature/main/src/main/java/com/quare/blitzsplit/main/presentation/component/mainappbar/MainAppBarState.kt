package com.quare.blitzsplit.main.presentation.component.mainappbar

import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel

sealed interface MainAppBarState {
    object Loading : MainAppBarState
    data class Success(val mainAppBarModel: MainAppBarModel) : MainAppBarState
}
