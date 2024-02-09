package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.navbar.BottomNavigationItem
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavBarItem
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavScreen
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavState
import javax.inject.Inject

class GetBottomBarFirstStateUseCase @Inject constructor() {

    operator fun invoke(onSelectItem: (BottomNavBarItem) -> Unit): BottomNavState = BottomNavState(
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
}
