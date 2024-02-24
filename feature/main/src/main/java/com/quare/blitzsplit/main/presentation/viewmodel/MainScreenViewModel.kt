package com.quare.blitzsplit.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.quare.blitzplit.component.chip.price.PriceChipsClicks
import com.quare.blitzsplit.main.domain.model.ModalBillClicks
import com.quare.blitzsplit.main.domain.usecase.GetMainAppBarModelUseCase
import com.quare.blitzsplit.main.domain.model.MainModalType
import com.quare.blitzsplit.main.domain.usecase.GetInitialPayDialogState
import com.quare.blitzsplit.main.domain.usecase.GetInitialReceiveDialogState
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
    private val getPayDialogState: GetInitialPayDialogState,
    private val getReceiveModalState: GetInitialReceiveDialogState,
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
        updateCurrentModal(
            MainModalType.Logout(
                onLogout = ::onClickLogout,
                onDismiss = ::onDismissDialog
            )
        )
    }

    private fun onClickLogout() {
        viewModelScope.launch {
            clearLocalUser()
            auth.signOut()
            _action.emit(MainScreenAction.BACK_TO_LOGIN)
        }
    }

    private fun onClickToPay() {
        updateCurrentModal(
            getPayDialogState(
                ModalBillClicks(
                    onBillButtonClick = {},
                    onConfirmButtonClick = {
                        // TOOD: update to paid off state
                        onDismissDialog()
                    },
                    onRevertButtonClick = {
                        // TOOD: revert dialog state
                        onDismissDialog()
                    },
                    onDismissButtonClick = ::onDismissDialog
                )
            )
        )
    }

    private fun onClickToReceive() {
        updateCurrentModal(
            getReceiveModalState(
                ModalBillClicks(
                    onBillButtonClick = {},
                    onConfirmButtonClick = {
                        // TOOD: update to paid off state
                        onDismissDialog()
                    },
                    onRevertButtonClick = {
                        // TOOD: revert dialog state
                        onDismissDialog()
                    },
                    onDismissButtonClick = ::onDismissDialog
                )
            )
        )
    }

    private fun onDismissDialog() {
        updateCurrentModal(null)
    }

    private fun updateCurrentModal(newDialog: MainModalType?) {
        _state.update { successUiState.copy(currentDialog = newDialog) }
    }
}
