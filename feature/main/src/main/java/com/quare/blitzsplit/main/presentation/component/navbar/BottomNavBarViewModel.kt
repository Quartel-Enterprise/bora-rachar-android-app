package com.quare.blitzsplit.main.presentation.component.navbar

import androidx.lifecycle.ViewModel
import com.quare.blitzplit.component.navbar.BottomNavigationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class BottomNavBarViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<BottomNavState> = MutableStateFlow(
        BottomNavState(
            selectedScreen = BottomNavScreen.GROUPS,
            items = listOf(
                BottomNavBarItem.Groups(isSelected = true),
                BottomNavBarItem.Contacts(isSelected = false),
                BottomNavBarItem.Activity(isSelected = false)
            ).map { item ->
                BottomNavigationItem(
                    title = item.title,
                    icon = item.icon,
                    isSelected = item.isSelected,
                    onClick = { onSelectItem(item) }
                )
            }
        )

    )

    val state: StateFlow<BottomNavState> = _state

    private fun onSelectItem(clickedItem: BottomNavBarItem) {
        _state.update {
            it.copy(
                items = it.items.map { item ->
                    item.getUpdated(clickedItem)
                },
                selectedScreen = clickedItem.screen
            )
        }
    }

    private fun BottomNavigationItem.getUpdated(
        clickedItem: BottomNavBarItem,
    ): BottomNavigationItem = copy(isSelected = title == clickedItem.title)
}
