package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.navbar.BottomNavigationItem
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavBarItem
import javax.inject.Inject

class GetUpdatedNavigationItemsUseCase @Inject constructor() {

    operator fun invoke(
        items: List<BottomNavigationItem>,
        clickedItem: BottomNavBarItem,
    ): List<BottomNavigationItem> = items.map { item ->
        item.getUpdated(clickedItem)
    }

    private fun BottomNavigationItem.getUpdated(
        clickedItem: BottomNavBarItem,
    ): BottomNavigationItem = copy(isSelected = title == clickedItem.title)
}
