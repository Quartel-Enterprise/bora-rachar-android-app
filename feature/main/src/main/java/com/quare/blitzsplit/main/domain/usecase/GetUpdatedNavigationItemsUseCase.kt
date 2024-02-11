package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzsplit.main.presentation.component.navbar.model.BottomNavigationItem
import com.quare.blitzsplit.main.presentation.component.navbar.model.BlitzSplitNavBarItem
import javax.inject.Inject

class GetUpdatedNavigationItemsUseCase @Inject constructor() {

    operator fun invoke(
        items: List<BottomNavigationItem>,
        clickedItem: BlitzSplitNavBarItem,
    ): List<BottomNavigationItem> = items.map { item ->
        item.getUpdated(clickedItem)
    }

    private fun BottomNavigationItem.getUpdated(
        clickedItem: BlitzSplitNavBarItem,
    ): BottomNavigationItem = copy(isSelected = title == clickedItem.title)
}
