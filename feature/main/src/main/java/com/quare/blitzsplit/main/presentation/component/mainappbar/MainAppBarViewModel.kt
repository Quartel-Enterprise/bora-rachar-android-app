package com.quare.blitzsplit.main.presentation.component.mainappbar

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzsplit.main.domain.usecase.GetMainAppBarModelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MainAppBarViewModel @Inject constructor(
    getMainAppBarModel: GetMainAppBarModelUseCase,
    private val auth: FirebaseAuth,
) : ViewModel() {

    private val _state: MutableStateFlow<MainAppBarModel> = MutableStateFlow(getMainAppBarModel())

    val state: StateFlow<MainAppBarModel> = _state

    fun onClickToPay() {
        // TODO: Emit action to show dialog with options to pay
    }

    fun onClickToReceive() {
        // TODO: Emit action to show dialog with options to receive
    }

    fun onClickLogout() {
        _state.update {
            it.copy(
                photoUrl = null,
                priceChipsModel = null
            )
        }
        auth.signOut()
    }
}
