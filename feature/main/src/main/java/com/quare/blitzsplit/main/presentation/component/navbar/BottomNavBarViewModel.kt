package com.quare.blitzsplit.main.presentation.component.navbar

import androidx.lifecycle.ViewModel
import com.quare.blitzsplit.main.domain.usecase.GetBottomBarFirstStateUseCase
import com.quare.blitzsplit.main.domain.usecase.GetUpdatedNavigationItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class BottomNavBarViewModel @Inject constructor(
    getBottomBarFirstState: GetBottomBarFirstStateUseCase,
    private val getUpdatedItems: GetUpdatedNavigationItemsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<BottomNavState> = MutableStateFlow(
        getBottomBarFirstState(::onSelectItem)
    )

    val state: StateFlow<BottomNavState> = _state

    private fun onSelectItem(clickedItem: BottomNavBarItem) {
        _state.update { bottomNavState ->
            bottomNavState.copy(
                items = getUpdatedItems(
                    items = bottomNavState.items,
                    clickedItem = clickedItem
                ),
                selectedScreen = clickedItem.screen
            )
        }
    }
}
