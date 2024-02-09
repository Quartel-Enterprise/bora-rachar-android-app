package com.quare.blitzsplit.main.presentation.component.navbar

import com.quare.blitzplit.component.navbar.BottomNavigationItem

data class BottomNavState(
    val items: List<BottomNavigationItem>,
    val selectedScreen: BottomNavScreen
)
