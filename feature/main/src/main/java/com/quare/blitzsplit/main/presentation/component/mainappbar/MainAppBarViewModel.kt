package com.quare.blitzsplit.main.presentation.component.mainappbar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzplit.component.pricechip.PriceChipsClicks
import com.quare.blitzsplit.main.domain.usecase.GetMainAppBarModelUseCase
import com.quare.blitzsplit.user.domain.usecase.ClearLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MainAppBarViewModel @Inject constructor(
    getMainAppBarModel: GetMainAppBarModelUseCase,
    private val auth: FirebaseAuth,
    private val clearLocalUser: ClearLocalUser,
) : ViewModel() {

    private val _state: MutableStateFlow<MainAppBarState> =
        MutableStateFlow(MainAppBarState.Loading)

    val state: StateFlow<MainAppBarState> = _state

    init {
        viewModelScope.launch {
            _state.update {
                MainAppBarState.Success(
                    mainAppBarModel = getMainAppBarModel(),
                    priceChipsClicks = PriceChipsClicks(
                        toPay = ::onClickToPay,
                        toReceive = ::onClickToReceive,
                    )
                )
            }
        }
    }

    private fun onClickToPay() {
        // TODO: Emit action to show dialog with options to pay
    }

    private fun onClickToReceive() {
        // TODO: Emit action to show dialog with options to receive
    }

    fun onClickLogout() {
        viewModelScope.launch {
            clearLocalUser()
            auth.signOut()
        }
    }
}
