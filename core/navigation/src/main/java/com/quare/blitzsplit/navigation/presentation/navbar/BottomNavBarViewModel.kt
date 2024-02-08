package com.quare.blitzsplit.navigation.presentation.navbar

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class BottomNavBarViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<List<BottomNavBarItem>> = MutableStateFlow(
        listOf(
            BottomNavBarItem.Groups(isSelected = true),
            BottomNavBarItem.Contacts(isSelected = false),
            BottomNavBarItem.Activity(isSelected = false)
        )
    )

    val state: StateFlow<List<BottomNavBarItem>> = _state

    fun onSelectItem(clickedItem: BottomNavBarItem) {
        _state.update { items ->
            items.map { item ->
                item.getUpdated(clickedItem)
            }
        }
    }

    private fun BottomNavBarItem.getUpdated(clickedItem: BottomNavBarItem) : BottomNavBarItem =
        if (route == clickedItem.route) select() else unSelect()
}
