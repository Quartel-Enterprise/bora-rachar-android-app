package com.quare.blitzsplit.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzplit.component.pricechip.PriceChipsClicks
import com.quare.blitzsplit.main.domain.usecase.GetMainAppBarModelUseCase
import com.quare.blitzsplit.main.domain.model.MainDialogType
import com.quare.blitzsplit.user.domain.usecase.ClearLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    getMainAppBarModel: GetMainAppBarModelUseCase,
    private val auth: FirebaseAuth,
    private val clearLocalUser: ClearLocalUser,
) : ViewModel() {

    private val _state: MutableStateFlow<MainAppBarState> =
        MutableStateFlow(MainAppBarState.Loading)

    val state: StateFlow<MainAppBarState> = _state

    private val _action: MutableSharedFlow<MainScreenAction> = MutableSharedFlow()
    val action: SharedFlow<MainScreenAction> = _action

    private val successUiState get() = _state.value as MainAppBarState.Success

    init {
        viewModelScope.launch {
            _state.update {
                MainAppBarState.Success(
                    mainAppBarModel = getMainAppBarModel(),
                    priceChipsClicks = PriceChipsClicks(
                        toPay = ::onClickToPay,
                        toReceive = ::onClickToReceive,
                    ),
                    currentDialog = null
                )
            }
        }
    }

    fun onProfilePictureClick() {
        updateCurrentDialog(MainDialogType.LOGOUT)
    }

    fun onDismissDialog() {
        updateCurrentDialog(null)
    }

    fun onClickLogout() {
        viewModelScope.launch {
            clearLocalUser()
            auth.signOut()
            _action.emit(MainScreenAction.BACK_TO_LOGIN)
        }
    }

    private fun onClickToPay() {
        updateCurrentDialog(MainDialogType.PAY)
    }

    private fun onClickToReceive() {
        updateCurrentDialog(MainDialogType.RECEIVE)
    }

    private fun updateCurrentDialog(newDialog: MainDialogType?) {
        _state.update { successUiState.copy(currentDialog = newDialog) }
    }
}
