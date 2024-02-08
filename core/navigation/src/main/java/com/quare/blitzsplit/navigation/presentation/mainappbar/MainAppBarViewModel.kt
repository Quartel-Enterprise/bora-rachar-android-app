package com.quare.blitzsplit.navigation.presentation.mainappbar

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzsplit.login.domain.usecase.GetUserDataUseCase
import com.quare.blitzsplit.navigation.usecase.GetPriceChipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MainAppBarViewModel @Inject constructor(
    getUserData: GetUserDataUseCase,
    getPriceChips: GetPriceChipsUseCase,
    private val auth: FirebaseAuth,
) : ViewModel() {

    private val firstState = MainAppBarModel(
        photoUrl = getUserData()?.profilePictureUrl,
        priceChipsModel = getPriceChips()
    )

    private val _state: MutableStateFlow<MainAppBarModel> = MutableStateFlow(firstState)

    val state: StateFlow<MainAppBarModel> = _state

    fun onClickToPay() {
        // TODO: Emit action to show dialog with options to pay
    }

    fun onClickToReceive() {
        // TODO: Emit action to show dialog with options to receive
    }

    fun onLogout() {
        auth.signOut()
        _state.update { firstState }
    }
}
