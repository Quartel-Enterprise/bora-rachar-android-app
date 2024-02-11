package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzsplit.main.presentation.component.navbar.model.BottomNavigationItem
import com.quare.blitzsplit.main.presentation.component.navbar.model.BlitzSplitNavBarItem
import com.quare.blitzsplit.main.presentation.component.navbar.model.BlitzSplitNavType
import com.quare.blitzsplit.main.presentation.viewmodel.bottom.BottomNavState
import javax.inject.Inject

class GetBottomBarFirstStateUseCase @Inject constructor() {

    operator fun invoke(onSelectItem: (BlitzSplitNavBarItem) -> Unit): BottomNavState = BottomNavState(
        selectedScreen = BlitzSplitNavType.GROUPS,
        items = listOf(
            BlitzSplitNavBarItem.Groups(isSelected = true),
            BlitzSplitNavBarItem.Contacts(isSelected = false),
            BlitzSplitNavBarItem.Activity(isSelected = false)
        ).map { item ->
            BottomNavigationItem(
                title = item.title,
                icon = item.icon,
                isSelected = item.isSelected,
                onClick = { onSelectItem(item) }
            )
        }
    )
}
