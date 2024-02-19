package com.quare.blitzsplit.navigation.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzsplit.navigation.domain.model.Route
import com.quare.blitzsplit.navigation.domain.usecase.GetLoadedNavigationStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val getLoadedNavigationState: GetLoadedNavigationStateUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<NavigationState> =
        MutableStateFlow(NavigationState.Loading)

    val state: StateFlow<NavigationState> = _state

    private val _action: MutableSharedFlow<NavigationAction> = MutableSharedFlow()
    val action: SharedFlow<NavigationAction> = _action

    init {
        viewModelScope.launch {
            _state.update {
                getLoadedNavigationState()
            }
        }
    }

    fun onGroupClick(groupId: String) {
        viewModelScope.launch {
            val route = "${Route.GROUP}/$groupId"
            _action.emit(NavigationAction.NavigateToGroupDetails(route))
        }
    }
}
